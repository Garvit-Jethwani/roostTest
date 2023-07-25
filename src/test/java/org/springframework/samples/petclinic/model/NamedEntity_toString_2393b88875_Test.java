package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testToString_NameExists() {
        String name = "Test Name";
        Mockito.when(namedEntity.getName()).thenReturn(name);
        Assertions.assertEquals(name, namedEntity.toString(),
                "Expected and actual names do not match");
    }

    @Test
    public void testToString_NameIsNull() {
        Mockito.when(namedEntity.getName()).thenReturn(null);
        Assertions.assertNull(namedEntity.toString(),
                "Expected null but found a name");
    }
}
