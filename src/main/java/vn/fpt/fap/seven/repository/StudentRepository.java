package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.fap.seven.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByUser_Id(String id);
}
