package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
