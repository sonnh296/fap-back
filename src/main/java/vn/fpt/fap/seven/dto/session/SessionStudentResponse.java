package vn.fpt.fap.seven.dto.session;

import lombok.*;
import vn.fpt.fap.seven.dto.room.RoomResponse;
import vn.fpt.fap.seven.dto.timeslot.TimeSlotResponse;

import java.sql.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SessionStudentResponse {
    private int sesId;
    private Date date_time;
    private RoomResponse room;
    private TimeSlotResponse timeSlot;
}
