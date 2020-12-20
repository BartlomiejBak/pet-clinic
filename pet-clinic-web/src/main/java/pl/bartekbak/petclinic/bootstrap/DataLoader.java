package pl.bartekbak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.bartekbak.petclinic.model.Owner;
import pl.bartekbak.petclinic.model.Vet;
import pl.bartekbak.petclinic.services.OwnerService;
import pl.bartekbak.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Owner First1");
        owner1.setLastName("Last1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Owner First2");
        owner2.setLastName("Last2");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

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
