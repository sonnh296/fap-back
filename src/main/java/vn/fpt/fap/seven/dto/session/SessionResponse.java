package vn.fpt.fap.seven.dto.session;

import lombok.*;
import vn.fpt.fap.seven.dto.attendance.AttendanceResponse;
import vn.fpt.fap.seven.dto.group.GroupResponse;
import vn.fpt.fap.seven.dto.room.RoomResponse;
import vn.fpt.fap.seven.dto.timeslot.TimeSlotResponse;
import vn.fpt.fap.seven.entity.Attendance;


import java.sql.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SessionResponse {
    private int sesId;
    private Date date_time;
    private RoomResponse room;
    private TimeSlotResponse timeSlot;
    //private List<AttendanceResponse> attendanceList;
}
