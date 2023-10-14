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
}
