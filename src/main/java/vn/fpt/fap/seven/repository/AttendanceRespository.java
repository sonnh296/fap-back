package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.fpt.fap.seven.entity.Attendance;

import java.util.List;

public interface AttendanceRespository extends JpaRepository<Attendance, Integer> {
    @Query("""
            SELECT a FROM Attendance a WHERE a.session.sesId = :sesId
            """)
    List<Attendance> findAttendanceBySessionId(int sesId);
}
