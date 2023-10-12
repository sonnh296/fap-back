package vn.fpt.fap.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllStudent() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @PutMapping("/attendance/{studentId}")
    public ResponseEntity<Map<String, Object>> updateAttendanceStudent(@PathVariable int studentId, RequestBody requestBody) {
        Map<String, Object> statusJson = new HashMap<>();
        Optional<Student> student = studentService.findStudentById(studentId);
//        if (!student.isPresent()) {
            statusJson.put("code", "404");
            statusJson.put("message", String.format("Student with id: '%d' can't be found to update!", studentId));
            return ResponseEntity.ok(statusJson);
//        }
//        try {
//            student.get().
//        } catch (Exception e)
    }
}
