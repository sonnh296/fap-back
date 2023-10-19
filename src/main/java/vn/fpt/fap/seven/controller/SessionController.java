package vn.fpt.fap.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.entity.Session;
import vn.fpt.fap.seven.service.impl.SessionServiceImpl;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionServiceImpl sessionService;

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<Session>> findSessionsByGroup(@PathVariable int groupId){
        return ResponseEntity.ok(sessionService.findSessionsByGroup(groupId));
    }
}
