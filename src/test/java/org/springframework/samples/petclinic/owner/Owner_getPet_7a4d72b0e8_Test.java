package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_7a4d72b0e8_Test {

    @Mock
    private Owner owner;

    private List<Pet> petList;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setName("Rex");
        petList.add(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Fido");
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);
    }

    @Test
    public void testGetPet_success() {
        Pet pet = owner.getPet("Rex");
        assertEquals("Rex", pet.getName());
    }

    @Test
    public void testGetPet_fail() {
        Pet pet = owner.getPet("Unknown");
        assertNull(pet);
    }
}
