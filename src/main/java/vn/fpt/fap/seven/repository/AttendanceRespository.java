package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.entity.Attendance;

import java.util.List;

public interface AttendanceRespository extends JpaRepository<Attendance, Integer> {
    @Query("""
            SELECT a FROM Attendance a WHERE a.session.sesId = :sesId
            """)
    List<Attendance> findAttendanceBySessionId(int sesId);

    @Query("""
            select a from Group g
            join Session ses on ses.group.gid = g.gid
            join Attendance a on a.session.sesId = ses.sesId
            where g.subject.id = :suId and a.student.id = :studentId and g.semester.Id = :semId
            """)
    Attendance findGroupByStudentIdAndSemIdAndSId(@Param("studentId") Integer studentId,
                                                  @Param("suId") Integer suId,
                                                  @Param("semId") Integer semId);

}
