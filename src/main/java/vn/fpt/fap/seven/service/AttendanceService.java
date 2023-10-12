package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<AttendanceResponse> findAttendanceBySessionId(int sesId);
}
