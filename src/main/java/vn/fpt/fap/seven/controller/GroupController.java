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

    private final GroupService groupService;

    private final AttendanceService attendanceService;

//    @GetMapping("/group/{studentId}")
//    @ResponseStatus(OK)
//    @PermitAll
//    public ApiResponse<List<GroupResponse>> getListGroup(@PathVariable("studentId") Integer studentId) {
//        List<GroupResponse> groupResponses = groupService.findListGroupByStudentId(studentId);
//        return ApiResponse.< List<GroupResponse>>builder()
//                .message("Get list attendance has: " + studentId + " success.")
//                .data(groupResponses)
//                .build();
//    }

    @GetMapping("/group/student_id/{studentId}/sem_id/{semId}/sub_id/{suId}")
    @ResponseStatus(OK)
    @PermitAll
    public ApiResponse<AttendanceResponse1> getGroup(@PathVariable("studentId") Integer studentId
            , @PathVariable("semId") Integer semId
            , @PathVariable("suId") Integer suId) {
        AttendanceResponse1 attendance = attendanceService.findGroupByStudentIdAndSemIdAndSId(studentId, semId, suId);
        return ApiResponse.<AttendanceResponse1>builder()
                .message("Get list student has studentId: " + studentId + " success.")
                .data(attendance)
                .build();
    }
}
