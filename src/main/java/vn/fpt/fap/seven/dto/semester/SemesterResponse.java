package vn.fpt.fap.seven.dto.semester;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SemesterResponse {
    private int Id;
    private String name;

}
