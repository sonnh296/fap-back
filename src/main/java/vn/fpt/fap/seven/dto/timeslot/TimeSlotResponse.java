package vn.fpt.fap.seven.dto.timeslot;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TimeSlotResponse {
    private int id;

    private String description;
}
