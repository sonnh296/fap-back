package vn.fpt.fap.seven.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse1;
import vn.fpt.fap.seven.dto.common.ApiResponse;
import vn.fpt.fap.seven.dto.group.GroupResponse;
import vn.fpt.fap.seven.service.AttendanceService;
import vn.fpt.fap.seven.service.GroupService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class GroupController {

    private final AttendanceService attendanceService;

    @GetMapping("/group/student_id/{studentId}/suId/{suId}/semId/{semId}")
    @ResponseStatus(OK)
    @PermitAll
    public ApiResponse<List<AttendanceResponse1>> getGroup(@PathVariable("studentId") Integer studentId
            , @PathVariable("suId") Integer suId
            , @PathVariable("semId") Integer semId) {
        List<AttendanceResponse1> attendances = attendanceService.findGroupByStudentIdAndSemIdAndSId(studentId, suId,semId);
        return ApiResponse.<List<AttendanceResponse1>>builder()
                .message("Get list student has studentId: " + studentId + " success.")
                .data(attendances)
                .build();
    }
}
