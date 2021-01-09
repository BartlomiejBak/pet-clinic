package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
