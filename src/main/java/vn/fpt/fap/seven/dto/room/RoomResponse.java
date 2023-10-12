package vn.fpt.fap.seven.dto.room;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomResponse {
    private int id;

    private String name;
}
