package vn.fpt.fap.seven.service;

import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Iterable<Student> findAllStudents();

    List<Student> findListStudentsByGroupId(int groupId);

    Optional<Student> findStudentById(int id);
}
