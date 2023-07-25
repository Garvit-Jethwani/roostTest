package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testGetName_WhenNameIsPresent() {
        String expectedName = "Test Name";
        when(namedEntity.getName()).thenReturn(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "The expected name should match the actual name");
    }

    @Test
    public void testGetName_WhenNameIsNull() {
        when(namedEntity.getName()).thenReturn(null);
        String actualName = namedEntity.getName();
        assertEquals(null, actualName, "The expected name should be null when the actual name is null");
    }
}
