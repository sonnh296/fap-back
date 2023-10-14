package vn.fpt.fap.seven.dto.attendance;

import lombok.*;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.entity.Session;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttendanceResponse1 {
    private boolean present;
    private String description;
    private SessionResponse session;
}
