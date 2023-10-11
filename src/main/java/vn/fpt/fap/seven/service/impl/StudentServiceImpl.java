package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.repository.StudentRepository;
import vn.fpt.fap.seven.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
