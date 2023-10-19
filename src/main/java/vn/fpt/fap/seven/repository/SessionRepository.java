package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.fap.seven.entity.Session;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    List<Session> getSessionsByGroup_Gid(int id);
}
