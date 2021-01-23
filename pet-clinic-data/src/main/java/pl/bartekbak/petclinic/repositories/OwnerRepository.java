package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
