package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.student.StudentResponse;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.repository.StudentRepository;
import vn.fpt.fap.seven.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


}
