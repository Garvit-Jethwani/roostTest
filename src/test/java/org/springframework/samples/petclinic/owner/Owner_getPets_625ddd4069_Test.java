package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.samples.petclinic.model.Pet;

public class Owner_getPets_625ddd4069_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setName("Rex");
        pet2 = new Pet();
        pet2.setName("Fido");
    }

    @Test
    public void testGetPets() {
        owner.addPet(pet1);
        owner.addPet(pet2);
        List<Pet> pets = owner.getPets();
        assertEquals(2, pets.size());
        assertEquals("Rex", pets.get(0).getName());
        assertEquals("Fido", pets.get(1).getName());
    }

    @Test
    public void testGetPetsEmpty() {
        List<Pet> pets = owner.getPets();
        assertEquals(0, pets.size());
    }
}
