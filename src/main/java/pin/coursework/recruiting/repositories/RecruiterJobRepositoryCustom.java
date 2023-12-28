package pin.coursework.recruiting.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pin.coursework.recruiting.models.ApplicantResume;
import pin.coursework.recruiting.models.RecruiterJob;

public interface RecruiterJobRepositoryCustom {
    @Query("SELECT rj FROM RecruiterJob rj WHERE rj.recruiterId = :id")
    Iterable<RecruiterJob> findRecruiterJobsById(@Param("id") Long id);
}
