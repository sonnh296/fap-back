package vn.fpt.fap.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.service.GroupService;
import vn.fpt.fap.seven.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    private final StudentService studentService;



    @GetMapping("list-student/{groupId}")
    public ResponseEntity<List<Student>> getListStudent(@PathVariable int groupId){
        return ResponseEntity.ok(studentService.findListStudentsByGroupId(groupId));
    }



}
