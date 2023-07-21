package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_a2da54c166_Test {

    private Owner testOwner;
    private Pet mockPet;

    @BeforeEach
    public void setup() {
        testOwner = new Owner();
        mockPet = Mockito.mock(Pet.class);

        List<Pet> petList = new ArrayList<>();
        petList.add(mockPet);
        testOwner.setPetsInternal(petList);
    }

    @Test
    public void testGetPet_ignoreNew() {
        when(mockPet.getName()).thenReturn("Fido");
        when(mockPet.isNew()).thenReturn(true);

        Pet result = testOwner.getPet("Fido", true);
        assertNull(result);

        result = testOwner.getPet("Fido", false);
        assertEquals(mockPet, result);
    }

    @Test
    public void testGetPet_nonExistentPet() {
        when(mockPet.getName()).thenReturn("Fido");
        when(mockPet.isNew()).thenReturn(false);

        Pet result = testOwner.getPet("Spot", false);
        assertNull(result);
    }
}
