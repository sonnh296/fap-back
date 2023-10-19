package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.fap.seven.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByGid(int id);

    List<Group> findGroupsByTeacher_Id(int id);
}
