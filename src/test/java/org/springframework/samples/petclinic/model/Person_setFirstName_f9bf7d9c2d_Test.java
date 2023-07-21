package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Person_setFirstName_f9bf7d9c2d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testSetFirstName_Success() {
        String expectedFirstName = "John";
        this.person.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName, this.person.getFirstName());
    }

    @Test
    public void testSetFirstName_Null() {
        String expectedFirstName = null;
        this.person.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName, this.person.getFirstName());
    }
}
