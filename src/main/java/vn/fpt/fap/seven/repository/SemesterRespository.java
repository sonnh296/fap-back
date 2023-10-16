package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.fap.seven.entity.Semester;


public interface SemesterRespository extends JpaRepository<Semester, Integer> {
}
