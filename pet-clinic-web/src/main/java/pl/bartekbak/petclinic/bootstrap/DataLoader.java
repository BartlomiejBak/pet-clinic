package pl.bartekbak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.bartekbak.petclinic.model.Owner;
import pl.bartekbak.petclinic.model.Pet;
import pl.bartekbak.petclinic.model.PetType;
import pl.bartekbak.petclinic.model.Vet;
import pl.bartekbak.petclinic.services.OwnerService;
import pl.bartekbak.petclinic.services.PetTypeService;
import pl.bartekbak.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types");

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Last1");
        owner1.setAddress("223 Street");
        owner1.setCity("London");
        owner1.setPhone("123456789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Bull");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Last2");
        owner2.setAddress("223 Street");
        owner2.setCity("London");
        owner2.setPhone("123456789");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthday(LocalDate.now());
        fionasPet.setName("Kitty");
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet First1");
        vet1.setLastName("Last1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet First2");
        vet2.setLastName("Last2");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
