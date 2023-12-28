package pin.coursework.recruiting.repositories;

import org.springframework.data.repository.CrudRepository;
import pin.coursework.recruiting.models.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant,Long> {
}
