package pin.coursework.recruiting.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "applicantsresumes")
public class ApplicantResume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    Long applicantId;
    String professionalExperience;
    String education;
    String skills;
    String projects;
    String certificates;
    String status;
}
