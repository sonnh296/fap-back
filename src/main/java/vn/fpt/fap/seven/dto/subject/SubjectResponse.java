package vn.fpt.fap.seven.dto.subject;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SubjectResponse {
    private int id;
    private String subjectName;
}
