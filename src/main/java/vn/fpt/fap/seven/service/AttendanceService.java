package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> findBySession(int id);
    List<Attendance> saveAll(List<Attendance> attendances);
    List<Attendance> findByGroupAndStudent(int gid, int id);
}
