package pl.bartekbak.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.bartekbak.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
