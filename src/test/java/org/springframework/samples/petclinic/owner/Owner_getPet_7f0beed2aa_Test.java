package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner_getPet_7f0beed2aa_Test {

    @InjectMocks
    Owner owner;

    @Mock
    Pet pet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPet() {
        String petName = "Fido";
        when(pet.getName()).thenReturn(petName);
        owner.addPet(pet);
        Pet retrievedPet = owner.getPet(petName);
        assertEquals(petName, retrievedPet.getName());
    }

    @Test
    public void testGetPetNotFound() {
        String petName = "Fido";
        Pet retrievedPet = owner.getPet(petName);
        assertEquals(null, retrievedPet);
    }
}
