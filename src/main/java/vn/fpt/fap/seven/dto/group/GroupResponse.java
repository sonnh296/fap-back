package vn.fpt.fap.seven.dto.group;

import lombok.*;
import vn.fpt.fap.seven.dto.subject.SubjectResponse;
import vn.fpt.fap.seven.entity.Subject;


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
    private SubjectResponse subject;
}
