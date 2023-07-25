package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Person_setFirstName_f9bf7d9c2d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetFirstName_Success() {
        String firstName = "John";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "The first name should be set correctly.");
    }

    @Test
    public void testSetFirstName_Null() {
        String firstName = null;
        assertThrows(NullPointerException.class, () -> person.setFirstName(firstName), "The first name cannot be null.");
    }

    @Test
    public void testSetFirstName_Empty() {
        String firstName = "";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "The first name can be an empty string.");
    }

    @Test
    public void testSetFirstName_LongString() {
        String firstName = "ThisIsAVeryLongFirstNameThatExceedsTheNormalLengthOfAFirstName";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "The first name can be a very long string.");
    }
}
