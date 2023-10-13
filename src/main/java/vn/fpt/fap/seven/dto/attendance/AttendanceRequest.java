package vn.fpt.fap.seven.dto.attendance;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import vn.fpt.fap.seven.dto.student.StudentResponse;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceRequest {
    @NotNull(message = "Attendance's id should not be null.")
    @Min(value = 1, message = "Attendance's id should more than 0")
    private int id;

    @NotNull(message = "Attendance's pesent should not be null.")
    private boolean present;

    @NotBlank(message = "Attendance's description should not be null.")
    private String description;

    @NotNull(message = "Attendance's record_time should not be null.")
    private Date record_time;

    @NotNull(message = "Attendance's student should not be null.")
    private StudentResponse student;

}
