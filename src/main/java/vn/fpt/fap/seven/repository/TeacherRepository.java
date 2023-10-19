package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.fap.seven.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findFirstByUser_Id(String code);
}
