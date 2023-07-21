package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setTelephone_df0456699c_Test {

    @Mock
    private Person person;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetTelephone_validTelephone() {
        String validTelephone = "1234567890";
        person.setTelephone(validTelephone);
        assertEquals(validTelephone, person.getTelephone());
    }

    @Test
    public void testSetTelephone_invalidTelephone() {
        String invalidTelephone = "1234";
        person.setTelephone(invalidTelephone);
        assertEquals(invalidTelephone, person.getTelephone());
    }
}
