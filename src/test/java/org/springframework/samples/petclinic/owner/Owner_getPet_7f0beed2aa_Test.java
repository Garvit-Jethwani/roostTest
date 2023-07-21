package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner_getPet_7f0beed2aa_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    Pet pet = new Pet();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPetSuccess() {
        String petName = "Max";
        when(pet.getName()).thenReturn(petName);
        List<Pet> pets = new ArrayList<>();
        pets.add(pet);
        owner.setPetsInternal(pets);
        Pet retrievedPet = owner.getPet(petName);
        assertEquals(petName, retrievedPet.getName());
    }

    @Test
    public void testGetPetFailure() {
        String petName = "Max";
        when(pet.getName()).thenReturn("Not Max");
        List<Pet> pets = new ArrayList<>();
        pets.add(pet);
        owner.setPetsInternal(pets);
        Pet retrievedPet = owner.getPet(petName);
        assertEquals(null, retrievedPet);
    }
}
