package vn.fpt.fap.seven.dto.student;

import lombok.*;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentResponse {
    private int id;
    private String name;
    private String email;
    private String studentCode;
}
