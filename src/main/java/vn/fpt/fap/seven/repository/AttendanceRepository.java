package vn.fpt.fap.seven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fpt.fap.seven.entity.Attendance;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> getAttendancesBySession_SesId(int id);
    List<Attendance> getAttendancesBySession_Group_GidAndStudent_Id(int gid, int id);
}
