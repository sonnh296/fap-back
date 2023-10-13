package vn.fpt.fap.seven.controller;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.dto.semester.SemesterResponseView;
import vn.fpt.fap.seven.service.SemesterService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SemesterController {
    private final SemesterService semesterService;

    @GetMapping("/list-semester")
    @PermitAll
    public ResponseEntity<List<SemesterResponseView>> getListSemester() {
        List<SemesterResponseView> listSemester =  semesterService.findAllSemester();
        return ResponseEntity.ok(listSemester);
    }


}
