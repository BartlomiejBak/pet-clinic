package pl.bartekbak.petclinic.services.map;

import org.springframework.stereotype.Service;
import pl.bartekbak.petclinic.model.Pet;
import pl.bartekbak.petclinic.services.PetService;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.deleteByObject(object);
    }
}
