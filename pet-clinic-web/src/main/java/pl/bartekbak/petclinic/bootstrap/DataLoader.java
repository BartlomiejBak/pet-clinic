package pl.bartekbak.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.bartekbak.petclinic.model.Owner;
import pl.bartekbak.petclinic.model.Vet;
import pl.bartekbak.petclinic.services.OwnerService;
import pl.bartekbak.petclinic.services.VetService;
import pl.bartekbak.petclinic.services.map.OwnerServiceMap;
import pl.bartekbak.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Owner First1");
        owner1.setLastName("Last1");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Owner First2");
        owner1.setLastName("Last2");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet First1");
        vet1.setLastName("Last1");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Vet First2");
        vet1.setLastName("Last2");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
