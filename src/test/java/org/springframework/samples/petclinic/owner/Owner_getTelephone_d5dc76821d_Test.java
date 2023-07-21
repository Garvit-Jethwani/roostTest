package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Owner_getTelephone_d5dc76821d_Test {

    private Owner owner;
    private String telephone;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        telephone = "1234567890";
        owner.setTelephone(telephone);
    }

    @Test
    public void testGetTelephone_Success() {
        String result = owner.getTelephone();
        assertEquals(telephone, result, "Telephone should match");
    }

    @Test
    public void testGetTelephone_Failure() {
        String wrongTelephone = "0987654321";
        String result = owner.getTelephone();
        assertNotEquals(wrongTelephone, result, "Telephone should not match");
    }
}
