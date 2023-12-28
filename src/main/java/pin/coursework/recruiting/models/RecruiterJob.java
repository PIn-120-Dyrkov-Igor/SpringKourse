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
@Table(name = "recruiterjobs")
public class RecruiterJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    Long recruiterId;
    String jobTitle;
    String jobDescription;
    String requirements;
    int salary;
    String location;
    String status;
}
