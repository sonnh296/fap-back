package vn.fpt.fap.seven.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.common.ApiResponse;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.dto.student.StudentResponse;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.service.AttendanceService;
import vn.fpt.fap.seven.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    private final AttendanceService attendanceService;

    @GetMapping("/group/{groupId}/session/{sessionId}")
    public ApiResponse<List<StudentResponse>> getListStudent(@PathVariable("groupId") int groupId, @PathVariable("sessionId") int sessionId){
        List<StudentResponse> studentResponses = studentService.findStudentsByGroupIdAndSessionId(groupId, sessionId);
        return ApiResponse.<List<StudentResponse>>builder()
                .message("Get list student by: " + groupId + " and " + sessionId + " success.")
                .data(studentResponses)
                .build();
    }

    @GetMapping("/attendance/{sesId}")
    @ResponseStatus(OK)
    @PermitAll
    public ApiResponse<List<AttendanceResponse>> getListAttendace(@PathVariable("sesId") Integer sesId){
        List<AttendanceResponse> attendances = attendanceService.findAttendanceBySessionId(sesId);
        return ApiResponse.<List<AttendanceResponse>>builder()
                .message("Get list attendance has: " + sesId + " success.")
                .data(attendances)
                .build();
    }

}
