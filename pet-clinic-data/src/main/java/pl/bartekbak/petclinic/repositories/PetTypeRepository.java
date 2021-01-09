package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
