package pin.coursework.recruiting.repositories;

import org.springframework.data.repository.CrudRepository;
import pin.coursework.recruiting.models.ApplicantResume;

public interface ApplicantResumeRepository extends CrudRepository<ApplicantResume,Long>, ApplicantResumeRepositoryCustom {

}
