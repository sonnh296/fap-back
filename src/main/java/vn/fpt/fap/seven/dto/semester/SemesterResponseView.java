package vn.fpt.fap.seven.dto.semester;

import lombok.*;
import vn.fpt.fap.seven.dto.subject.SubjectResponse;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SemesterResponseView {
    private int Id;

    private String name;

    private List<SubjectResponse> listSubject;
}
