package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.dto.attendance.AttendanceRequest;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.entity.Attendance;
import vn.fpt.fap.seven.repository.AttendanceRespository;

import java.util.List;

public interface AttendanceService {
    List<AttendanceResponse> findAttendanceBySessionId(int sesId);
    void updateListAttendance(int sesId, List<AttendanceRequest> attendanceRequest);
}
