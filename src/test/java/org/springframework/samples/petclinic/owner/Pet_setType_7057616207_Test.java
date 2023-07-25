package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.PetType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Pet_setType_7057616207_Test {

    @Mock
    private Pet pet;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetType() {
        PetType type = new PetType();
        type.setName("Dog");
        when(pet.getType()).thenReturn(type);

        pet.setType(type);
        PetType actualType = pet.getType();

        assertEquals(type, actualType);
    }

    @Test
    public void testSetTypeNull() {
        when(pet.getType()).thenReturn(null);

        pet.setType(null);
        PetType actualType = pet.getType();

        assertNull(actualType);
    }
}
