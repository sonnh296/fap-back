package vn.fpt.fap.seven.dto.session;

import lombok.*;
import vn.fpt.fap.seven.dto.group.GroupResponse;
import vn.fpt.fap.seven.dto.room.RoomResponse;
import vn.fpt.fap.seven.dto.timeslot.TimeSlotResponse;


import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SessionResponse {
    private int sesId;
    private boolean attandence;
    private int theIndex;
    private Date date_time;
    private GroupResponse group;
    private RoomResponse room;
    private TimeSlotResponse timeSlot;
}