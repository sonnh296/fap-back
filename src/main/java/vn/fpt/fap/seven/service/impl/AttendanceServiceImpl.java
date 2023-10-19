package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.entity.Attendance;
import vn.fpt.fap.seven.repository.AttendanceRepository;
import vn.fpt.fap.seven.service.AttendanceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    @Override
    public List<Attendance> findBySession(int id) {
        return attendanceRepository.getAttendancesBySession_SesId(id);
    }

    @Override
    public List<Attendance> saveAll(List<Attendance> attendances) {
        return attendanceRepository.saveAll(attendances);
    }

    @Override
    public List<Attendance> findByGroupAndStudent(int gid, int id) {
        return attendanceRepository.getAttendancesBySession_Group_GidAndStudent_Id(gid, id);
    }
}
