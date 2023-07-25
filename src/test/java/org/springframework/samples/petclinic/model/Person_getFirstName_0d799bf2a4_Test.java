package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Person_getFirstName_0d799bf2a4_Test {

    private Person person;

    @BeforeEach
    void setup() {
        this.person = new Person();
    }

    @Test
    public void testGetFirstName_whenFirstNameIsSet() {
        String expectedFirstName = "John";
        this.person.setFirstName(expectedFirstName);
        String actualFirstName = this.person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName, "The first name returned does not match the expected first name");
    }

    @Test
    public void testGetFirstName_whenFirstNameIsNotSet() {
        String expectedFirstName = null;
        String actualFirstName = this.person.getFirstName();
        assertEquals(expectedFirstName, actualFirstName, "The first name returned does not match the expected first name (null)");
    }
}
