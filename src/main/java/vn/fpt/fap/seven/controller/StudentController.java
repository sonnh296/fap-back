package vn.fpt.fap.seven.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.fpt.fap.seven.service.StudentService;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


}
