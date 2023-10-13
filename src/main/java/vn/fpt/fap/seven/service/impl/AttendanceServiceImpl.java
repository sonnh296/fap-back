package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.entity.Attendance;
import vn.fpt.fap.seven.repository.AttendanceRespository;
import vn.fpt.fap.seven.service.AttendanceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRespository attendanceRespository;
    private final ModelMapper modelMapper;

    @Override
    public List<AttendanceResponse> findAttendanceBySessionId(int sesId) {
        List<Attendance> attendances = attendanceRespository.findAttendanceBySessionId(sesId);
        List<AttendanceResponse> attendanceResponses = attendances.stream()
                .map(attendanceMap -> modelMapper.map(attendanceMap, AttendanceResponse.class))
                .toList();
        return attendanceResponses;
    }
}
