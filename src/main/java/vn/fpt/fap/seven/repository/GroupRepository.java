package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.fpt.fap.seven.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("SELECT g FROM Group g WHERE g.teacher.id = :id")
    List<Group> findGroupsByTeacherId(@Param("id") int teacherId);
}
