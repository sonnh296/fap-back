package vn.fpt.fap.seven.dto.group;

import lombok.*;
import vn.fpt.fap.seven.dto.session.SessionRequest;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroupRequest {
    private int gId;

    private SessionRequest sessionRequest;
}
