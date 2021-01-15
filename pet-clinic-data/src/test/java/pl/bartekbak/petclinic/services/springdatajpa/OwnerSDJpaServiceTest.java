package pl.bartekbak.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.bartekbak.petclinic.model.Owner;
import pl.bartekbak.petclinic.repositories.OwnerRepository;
import pl.bartekbak.petclinic.repositories.PetRepository;
import pl.bartekbak.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;
    String lastName = "Smith";

    @BeforeEach
    void setUp() {
    returnOwner = Owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(lastName);
        assertEquals(1L, smith.getId());
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1L).build());
        returnedOwnerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners = service.findAll();

        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(returnOwner);
        Owner saved = service.save(new Owner());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}
