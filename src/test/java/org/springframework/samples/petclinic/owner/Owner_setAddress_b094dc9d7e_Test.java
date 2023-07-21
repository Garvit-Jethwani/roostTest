package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_setAddress_b094dc9d7e_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = Mockito.mock(Person.class);
    }

    @Test
    public void testSetAddress_ValidAddress() {
        String validAddress = "123 Main St";
        Mockito.when(person.getAddress()).thenReturn(validAddress);
        person.setAddress(validAddress);
        Mockito.verify(person).setAddress(validAddress);
        Assert.isTrue(person.getAddress().equals(validAddress), "Address does not match the expected value");
    }

    @Test
    public void testSetAddress_EmptyAddress() {
        String emptyAddress = "";
        Mockito.when(person.getAddress()).thenReturn(emptyAddress);
        person.setAddress(emptyAddress);
        Mockito.verify(person).setAddress(emptyAddress);
        Assert.isTrue(person.getAddress().equals(emptyAddress), "Address does not match the expected value");
    }

    @Test
    public void testSetAddress_NullAddress() {
        String nullAddress = null;
        Mockito.when(person.getAddress()).thenReturn(nullAddress);
        person.setAddress(nullAddress);
        Mockito.verify(person).setAddress(nullAddress);
        Assert.isNull(person.getAddress(), "Address is not null as expected");
    }
}
