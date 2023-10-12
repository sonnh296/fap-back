package vn.fpt.fap.seven.dto.student;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentResponse {
    private int id;
    private String name;

    private String email;

    private String studentCode;
}
