package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
