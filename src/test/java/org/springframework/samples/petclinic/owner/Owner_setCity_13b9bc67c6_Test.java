package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_setCity_13b9bc67c6_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetCity() {
        String city = "New York";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }

    @Test
    public void testSetCityWithNull() {
        person.setCity(null);
        assertNull(person.getCity());
    }

    @Test
    public void testSetCityWithEmptyString() {
        String city = "";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }

    @Test
    public void testSetCityWithWhiteSpace() {
        String city = " ";
        person.setCity(city);
        assertEquals(city, person.getCity());
    }
}
