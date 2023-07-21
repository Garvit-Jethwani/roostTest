package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetLastName_Success() {
        person.setLastName("Smith");
        String lastName = person.getLastName();
        assertEquals("Smith", lastName);
    }

    @Test
    public void testGetLastName_Null() {
        person.setLastName(null);
        String lastName = person.getLastName();
        assertEquals(null, lastName);
    }
}
