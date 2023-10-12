package vn.fpt.fap.seven.dto.group;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroupResponse {

    private int gid;
    private String gname;
    private String sem;
    private int year;
}
