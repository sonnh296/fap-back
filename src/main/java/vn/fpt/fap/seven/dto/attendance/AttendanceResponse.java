package vn.fpt.fap.seven.dto.attendance;

import lombok.*;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.dto.student.StudentResponse;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceResponse {
    private int id;
    private boolean present;
    private String description;
    private Date record_time;
    private StudentResponse student;
}
