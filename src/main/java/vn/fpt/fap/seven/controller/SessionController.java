package vn.fpt.fap.seven.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.dto.common.ApiResponse;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.service.GroupService;
import vn.fpt.fap.seven.service.SessionService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;
    private final GroupService groupService;


    @GetMapping("/list-sessions/{teacherId}")
    @ResponseStatus(OK)
    @PermitAll
    public ApiResponse<List<SessionResponse>> getListSession(@PathVariable("teacherId") Integer teacherId){
        List<SessionResponse> sessions = sessionService.findSessionsByTeacherId(teacherId);
        return ApiResponse.<List<SessionResponse>>builder()
                .message("Get list session has: " + teacherId + " success.")
                .data(sessions)
                .build();
    }


}
