package pl.bartekbak.petclinic.services;

import pl.bartekbak.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
