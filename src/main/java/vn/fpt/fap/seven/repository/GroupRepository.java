package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.dto.group.GroupResponse;
import vn.fpt.fap.seven.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("SELECT g FROM Group g WHERE g.teacher.id = :id")
    List<Group> findGroupsByTeacherId(@Param("id") int teacherId);

    @Query("SELECT g FROM Student s JOIN s.groupList g WHERE s.id = :studentId")
    List<Group> findListGroupByStudentId(int studentId);

/*    @Query("""
            SELECT g FROM Group g 
            JOIN g.studentList sg
            JOIN Teacher t ON t.id = g.teacher.id
            JOIN Semester sem ON sem.Id = g.semester.Id
            JOIN Subject sub ON sub.id = g.subject.id
            WHERE sg.id = :studentId AND sem.Id = :semId AND sub.id = :suId""")
    Group findGroupByStudentIdAndSemIdAndSId(@Param("studentId") Integer studentId,
                                             @Param("semId") Integer semId,
                                             @Param("suId") Integer suId);*/

    @Query("""
            select g from Group g
            join Session ses on ses.group.gid = g.gid
            join Attendance a on a.session.sesId = ses.sesId
            where g.subject.id = :suId and a.student.id = :studentId and g.semester.Id = :semId
            """)
    Group findGroupByStudentIdAndSemIdAndSId(@Param("studentId") Integer studentId,
                                             @Param("suId") Integer suId,
                                             @Param("semId") Integer semId);

//    SELECT g, ses, a
//    FROM Group g
//    JOIN g.sessionList ses
//    JOIN ses.attendanceList a
//    WHERE g.subject.id = :suId and a.student.id = :studentId and g.semester.Id = :semId
}
