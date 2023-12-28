package pin.coursework.recruiting.repositories;

import org.springframework.data.repository.CrudRepository;
import pin.coursework.recruiting.models.RecruiterJob;

public interface RecruiterJobRepository extends CrudRepository<RecruiterJob,Long>, RecruiterJobRepositoryCustom {
}
