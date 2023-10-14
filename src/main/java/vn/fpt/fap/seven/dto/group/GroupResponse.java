package vn.fpt.fap.seven.dto.group;

import lombok.*;
import vn.fpt.fap.seven.dto.semester.SemesterResponse;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.dto.subject.SubjectResponse;
import vn.fpt.fap.seven.dto.teacher.TeacherResponse;
import vn.fpt.fap.seven.entity.Session;
import vn.fpt.fap.seven.entity.Subject;
import vn.fpt.fap.seven.repository.TeacherRepository;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroupResponse {
    private int gid;
    private String gname;
    private int year;
    private SubjectResponse subject;
    private TeacherResponse teacher;
    private SemesterResponse semester;
    private List<SessionResponse> sessionList;
}
