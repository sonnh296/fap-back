package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s JOIN s.groupList g WHERE g.gid = :gid")
    List<Student> findListStudentsByGroupId(@Param("gid") int groupId);
}
