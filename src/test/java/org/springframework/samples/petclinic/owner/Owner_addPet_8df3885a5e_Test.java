package org.springframework.samples.petclinic.owner;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.*;

public class Owner_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet2 = new Pet();
        pet2.setId(2);
    }

    @Test
    public void testAddPetNew() {
        owner.addPet(pet1);
        Set<Pet> pets = owner.getPets();
        assertTrue(pets.contains(pet1));
    }

    @Test
    public void testAddPetExisting() {
        owner.addPet(pet2);
        Set<Pet> pets = owner.getPets();
        assertTrue(pets.contains(pet2)); //Asserting that pet2 is in the owner's pets
    }
}
