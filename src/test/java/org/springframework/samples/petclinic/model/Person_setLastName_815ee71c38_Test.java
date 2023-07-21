package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Person_setLastName_815ee71c38_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetLastName() {
        String lastName = "Smith";
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName(), "The last name should be set correctly.");
    }

    @Test
    public void testSetLastNameWithNull() {
        assertThrows(NullPointerException.class, () -> person.setLastName(null), "Null last name should throw an exception.");
    }

    @Test
    public void testSetLastNameWithEmptyString() {
        String lastName = "";
        person.setLastName(lastName);
        assertEquals(lastName, person.getLastName(), "The last name should be set correctly even if it's an empty string.");
    }
}
