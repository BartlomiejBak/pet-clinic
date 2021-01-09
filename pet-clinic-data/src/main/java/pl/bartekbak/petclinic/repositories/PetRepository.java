package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
