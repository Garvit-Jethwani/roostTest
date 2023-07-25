package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.util.Assert;

public class Owner_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet pet;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = Mockito.mock(Pet.class);
    }

    @Test
    public void testAddPet_newPet() {
        Mockito.when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);
        List<Pet> pets = new ArrayList<>(owner.getPets());
        Assert.isTrue(pets.contains(pet), "New pet should be added to the owner's pet list");
    }

    @Test
    public void testAddPet_existingPet() {
        Mockito.when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);
        List<Pet> pets = new ArrayList<>(owner.getPets());
        Assert.isTrue(!pets.contains(pet), "Existing pet should not be added to the owner's pet list");
    }
}
