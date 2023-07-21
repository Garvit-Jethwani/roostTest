package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName() {
        String testName = "Test Name";
        namedEntity.setName(testName);

        assertEquals(testName, namedEntity.getName());
    }

    @Test
    public void testSetNameWithNull() {
        String testName = null;

        assertThrows(NullPointerException.class, () -> {
            namedEntity.setName(testName);
        });
    }
}
