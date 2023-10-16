package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.entity.Session;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    @Query("SELECT s FROM Session s " +
            "WHERE s.teacher.id = :teacherId")
    List<Session> findSessionsByTeacherId(int teacherId);
}
