package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.entity.Teacher;
import vn.fpt.fap.seven.repository.TeacherRepository;
import vn.fpt.fap.seven.service.TeacherService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public Optional<Teacher> findById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Optional<Teacher> findByCode(String code) {
        return Optional.ofNullable(teacherRepository.findFirstByUser_Id(code));
    }
}
