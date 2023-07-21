package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testToString_WhenNameIsNotNull() {
        Mockito.when(namedEntity.getName()).thenReturn("Test Name");
        String result = namedEntity.toString();
        assertEquals("Test Name", result);
    }

    @Test
    public void testToString_WhenNameIsNull() {
        Mockito.when(namedEntity.getName()).thenReturn(null);
        String result = namedEntity.toString();
        assertNull(result);
    }
}
