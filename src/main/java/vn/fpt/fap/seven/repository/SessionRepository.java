package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.entity.Session;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    @Query("SELECT se FROM Session se JOIN se.timeSlot ts JOIN se.teacher t WHERE ts.id = :timeId AND t.id = :teacherId")
    List<Session> findListSessionByTeacherIdAndTimeSlotId(@Param("timeId") int timeId, @Param("teacherId") int teacherId);

    @Query("SELECT s FROM Session s " +
            "WHERE s.teacher.id = :teacherId")
    List<Session> findSessionsByTeacherId(int teacherId);
}
