package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.style.ToStringCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_toString_2393b88875_Test {

    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
        owner.setId(1);
        owner.setNew(true);
        owner.setLastName("Doe");
        owner.setFirstName("John");
        owner.setAddress("123 Main St");
        owner.setCity("Springfield");
        owner.setTelephone("555-555-5555");
    }

    @Test
    public void testToString() {
        String expected = new ToStringCreator(owner)
                .append("id", 1)
                .append("new", true)
                .append("lastName", "Doe")
                .append("firstName", "John")
                .append("address", "123 Main St")
                .append("city", "Springfield")
                .append("telephone", "555-555-5555")
                .toString();

        String actual = owner.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithNullValues() {
        owner.setLastName(null);
        owner.setFirstName(null);
        owner.setAddress(null);
        owner.setCity(null);
        owner.setTelephone(null);

        String expected = new ToStringCreator(owner)
                .append("id", 1)
                .append("new", true)
                .append("lastName", null)
                .append("firstName", null)
                .append("address", null)
                .append("city", null)
                .append("telephone", null)
                .toString();

        String actual = owner.toString();

        assertEquals(expected, actual);
    }
}
