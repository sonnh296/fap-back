package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.attendance.AttendanceRequest;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse1;
import vn.fpt.fap.seven.dto.group.GroupResponse;
import vn.fpt.fap.seven.entity.Attendance;
import vn.fpt.fap.seven.entity.Group;
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

    @Override
    public void updateListAttendance(int sesId, List<AttendanceRequest> attendanceRequest){
        List<Attendance> attendance = attendanceRespository.findAttendanceBySessionId(sesId);
        for (int i = 0; i < attendance.size(); i++) {
            Attendance exiting = attendance.get(i);
            AttendanceRequest request = attendanceRequest.get(i);
            exiting.setPresent(request.isPresent());
        }
        attendanceRespository.saveAll(attendance);
    }

    @Override
    public List<AttendanceResponse1> findGroupByStudentIdAndSemIdAndSId(int studentId, int suId, int semId) {
        List<Attendance> attendances = attendanceRespository.findGroupByStudentIdAndSemIdAndSId(studentId, suId, semId);
        return attendances.stream()
                .map(attendanceMap -> modelMapper.map(attendanceMap, AttendanceResponse1.class))
                .toList();
    }

    /*@Override
    public AttendanceResponse findGroupByStudentIdAndSemIdAndSId(int studentId, int suId, int semId) {
        Attendance attendance = attendanceRespository.findGroupByStudentIdAndSemIdAndSId(studentId, suId, semId);
        return modelMapper.map(attendance, AttendanceResponse.class);
    }*/
}
