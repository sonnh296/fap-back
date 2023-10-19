package vn.fpt.fap.seven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.entity.Attendance;
import vn.fpt.fap.seven.service.impl.AttendanceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceServiceImpl attendanceService;

    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<List<Attendance>> takeAttendance(@RequestBody List<Attendance> attendances){
        return ResponseEntity.ok(attendanceService.saveAll(attendances));
    }

    @GetMapping("/group/{gid}/student/{sid}")
    public ResponseEntity<List<Attendance>> viewAttendanceForStudent(@PathVariable int gid, @PathVariable int sid){
        return ResponseEntity.ok(attendanceService.findByGroupAndStudent(gid, sid));
    }
}
