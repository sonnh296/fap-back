package vn.fpt.fap.seven.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.service.impl.GroupServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/v1/auth/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupServiceImpl groupService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Group>>  findGroupByTeacher(@PathVariable int teacherId){
        return ResponseEntity.ok(groupService.findByTeacherId(teacherId));
    }
}
