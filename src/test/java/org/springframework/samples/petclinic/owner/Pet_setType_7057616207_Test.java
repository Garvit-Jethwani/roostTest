package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class Pet_setType_7057616207_Test {

    private Pet pet;

    @BeforeEach
    public void setUp() {
        pet = new Pet();
    }

    @Test
    public void testSetType() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
        assertEquals(type, pet.getType());
    }

    @Test
    public void testSetType_null() {
        pet.setType(null);
        assertNull(pet.getType());
    }
}
