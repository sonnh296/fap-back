package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.student.StudentResponse;
import vn.fpt.fap.seven.entity.Student;
import vn.fpt.fap.seven.repository.StudentRepository;
import vn.fpt.fap.seven.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponse> findStudentsByGroupIdAndSessionId(int groupId, int sessionId) {
        List<Student> studentResponses = studentRepository.findStudentsByGroupIdAndSessionId(groupId, sessionId);
        return studentResponses.stream()
                .map(studentMap -> modelMapper.map(studentMap, StudentResponse.class))
//                .map(student -> {
//                    StudentResponse student1 = modelMapper.map(student, StudentResponse.class);
//                    student1.setListAttendanceResponse(student.getAttendanceList().stream().map(attendance -> modelMapper.map(attendance, AttendanceResponse.class)).toList());
//                    return student1;
//                })
                .toList();
    }
}
