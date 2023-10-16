package vn.fpt.fap.seven.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.fpt.fap.seven.user.User;

import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "student_code")
    private String studentCode;

    @OneToOne
    @JoinColumn(name = "student_id")
    private User user;

    @OneToMany(mappedBy = "student",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "Student_Group",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "groupId")
    )
    private List<Group> groupList;
}
