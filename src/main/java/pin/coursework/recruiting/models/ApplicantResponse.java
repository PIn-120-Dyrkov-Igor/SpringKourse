package pin.coursework.recruiting.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "applicantresponses")
public class ApplicantResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    Long jobId;
    Long applicantResumeId;
    Date responseDate;
    String coverLetter;
    String status;
}
