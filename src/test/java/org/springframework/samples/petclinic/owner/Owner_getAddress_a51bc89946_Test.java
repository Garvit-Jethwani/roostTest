package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getAddress_a51bc89946_Test {

    @Test
    public void testGetAddress() {
        Person person = new Person();
        person.setAddress("123 Main St");
        assertEquals("123 Main St", person.getAddress());
    }

    @Test
    public void testGetAddress_Empty() {
        Person person = new Person();
        person.setAddress("");
        assertEquals("", person.getAddress());
    }

    @Test
    public void testGetAddress_Null() {
        Person person = new Person();
        person.setAddress(null);
        assertEquals(null, person.getAddress());
    }
}
