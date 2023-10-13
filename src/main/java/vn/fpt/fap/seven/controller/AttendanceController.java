package vn.fpt.fap.seven.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.dto.attendance.AttendanceRequest;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.common.ApiResponse;
import vn.fpt.fap.seven.service.AttendanceService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @GetMapping("/attendance/{sesId}")
    @ResponseStatus(OK)
    @PermitAll
    public ApiResponse<List<AttendanceResponse>> getListAttendace(@PathVariable("sesId") Integer sesId) {
        List<AttendanceResponse> attendances = attendanceService.findAttendanceBySessionId(sesId);
        return ApiResponse.<List<AttendanceResponse>>builder()
                .message("Get list attendance has: " + sesId + " success.")
                .data(attendances)
                .build();
    }

    @PutMapping("/update-attendance/{sesId}")
    @ResponseStatus(OK)
    public ApiResponse updateLesson(@Valid @RequestBody List<AttendanceRequest> listAttendanceRequest,
                                    @PathVariable("sesId") Integer sesId) {
        attendanceService.updateListAttendance(sesId, listAttendanceRequest);
        return ApiResponse.builder()
                .message("Create attendance success.")
                .build();
    }
}
