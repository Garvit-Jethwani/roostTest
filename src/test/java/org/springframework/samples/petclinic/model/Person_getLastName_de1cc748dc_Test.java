package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetLastNameWhenLastNameIsSet() {
        String expectedLastName = "Smith";
        this.person.setLastName(expectedLastName);

        String actualLastName = this.person.getLastName();

        assertEquals(expectedLastName, actualLastName, "The expected last name does not match the actual last name");
    }

    @Test
    public void testGetLastNameWhenLastNameIsNotSet() {
        String actualLastName = this.person.getLastName();

        assertEquals(null, actualLastName, "The expected last name does not match the actual last name");
    }
}
