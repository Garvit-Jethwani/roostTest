package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_a2da54c166_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setup() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);

        Set<Pet> pets = new HashSet<>(Arrays.asList(pet1, pet2));
        owner.setPetsInternal(pets);

        when(pet1.getName()).thenReturn("fido");
        when(pet2.getName()).thenReturn("rex");
    }

    @Test
    public void testGetPet_ignoreNew() {
        when(pet1.isNew()).thenReturn(true);
        when(pet2.isNew()).thenReturn(false);

        Pet foundPet = owner.getPet("fido", true);
        assertNull(foundPet, "New pet should be ignored");

        foundPet = owner.getPet("rex", true);
        assertEquals(pet2, foundPet, "Existing pet should be returned");
    }

    @Test
    public void testGetPet_notIgnoreNew() {
        when(pet1.isNew()).thenReturn(true);
        when(pet2.isNew()).thenReturn(false);

        Pet foundPet = owner.getPet("fido", false);
        assertEquals(pet1, foundPet, "New pet should be returned");

        foundPet = owner.getPet("rex", false);
        assertEquals(pet2, foundPet, "Existing pet should be returned");
    }

    @Test
    public void testGetPet_nonExistingPet() {
        Pet foundPet = owner.getPet("notExistingPet", true);
        assertNull(foundPet, "Non existing pet should return null");

        foundPet = owner.getPet("notExistingPet", false);
        assertNull(foundPet, "Non existing pet should return null");
    }
}
