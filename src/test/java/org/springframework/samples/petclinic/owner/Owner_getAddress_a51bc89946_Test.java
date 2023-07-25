package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getAddress_a51bc89946_Test {

    private Person owner;

    @BeforeEach
    public void setup() {
        owner = new Person();
        owner.setAddress("123 Main St");
    }

    @Test
    public void testGetAddress_Success() {
        String expectedAddress = "123 Main St";
        String actualAddress = owner.getAddress();
        assertEquals(expectedAddress, actualAddress, "Expected address does not match actual address");
    }

    @Test
    public void testGetAddress_Failure() {
        String expectedAddress = "456 Maple Ave";
        String actualAddress = owner.getAddress();
        assertEquals(expectedAddress, actualAddress, "Expected address does not match actual address");
    }
}
