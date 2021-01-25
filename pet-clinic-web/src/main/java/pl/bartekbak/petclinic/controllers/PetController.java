package pl.bartekbak.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bartekbak.petclinic.model.Owner;
import pl.bartekbak.petclinic.model.PetType;
import pl.bartekbak.petclinic.services.OwnerService;
import pl.bartekbak.petclinic.services.PetService;
import pl.bartekbak.petclinic.services.PetTypeService;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    public static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void InitOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
