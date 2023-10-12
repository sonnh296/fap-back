package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("""
            SELECT s, g, a, se
            FROM Student s
            JOIN s.groupList g
            JOIN s.attendanceList a
            JOIN a.session se
            WHERE g.gid = :groupId AND se.sesId = :sessionId
            """)
    List<Student> findStudentsByGroupIdAndSessionId(int groupId, int sessionId);
}
