package pin.coursework.recruiting.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pin.coursework.recruiting.models.ApplicantResume;

public interface ApplicantResumeRepositoryCustom {
    @Query("SELECT ar FROM ApplicantResume ar WHERE ar.applicantId = :id")
    Iterable<ApplicantResume> findApplicantResumesById(@Param("id") Long id);

}
