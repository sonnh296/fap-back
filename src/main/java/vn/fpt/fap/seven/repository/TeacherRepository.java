package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.entity.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
