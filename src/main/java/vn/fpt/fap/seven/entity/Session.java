package vn.fpt.fap.seven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sessionss")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sesId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date_time;

    private int theIndex;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "groupId")
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "roomId")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "timeId")
    private TimeSlot timeSlot;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    private boolean attandence;

    @JsonProperty("subject")
    public String getSubjectFromGroup() {
        if (group != null) {
            return group.getSubject().getSubjectName();
        }
        return null;
    }

    @JsonProperty("group")
    public String getGroupName() {
        if (group != null) {
            return group.getGname();
        }
        return null;
    }
}