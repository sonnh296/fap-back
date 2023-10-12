package vn.fpt.fap.seven.dto.session;

import lombok.*;

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
}
