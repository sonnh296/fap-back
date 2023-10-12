package vn.fpt.fap.seven.dto.teacher;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TeacherResponse {
    private int id;
    private String name;
    private String email;

}
