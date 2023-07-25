package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.samples.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Owner_getPets_625ddd4069_Test {

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
    }

    @Test
    void testGetPetsWhenPetsListIsNull() {
        assertNull(owner.getPets());
    }

    @Test
    void testGetPetsWhenPetsListIsNotEmpty() {
        List<Pet> pets = new ArrayList<>();
        Pet pet = new Pet();
        pets.add(pet);
        owner.setPets(pets);
        assertNotNull(owner.getPets());
        assertEquals(1, owner.getPets().size());
        assertEquals(pet, owner.getPets().get(0));
    }
}
