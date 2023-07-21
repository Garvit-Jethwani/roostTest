package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.PetType;

public class Pet_getType_5e69a8c7da_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetType_whenTypeIsSet() {
        PetType type = mock(PetType.class);
        pet.setType(type);
        assertEquals(type, pet.getType());
    }

    @Test
    public void testGetType_whenTypeIsNotSet() {
        assertEquals(null, pet.getType());
    }
}
