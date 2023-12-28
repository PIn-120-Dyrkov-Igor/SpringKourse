package pin.coursework.recruiting.repositories;

import org.springframework.data.repository.CrudRepository;
import pin.coursework.recruiting.models.Interview;

public interface InterviewRepository extends CrudRepository<Interview,Long> {
}
