package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void setUp() {
        this.owner = new Owner();
    }

    @Test
    public void testSetTelephone() {
        String telephone = "1234567890";
        this.owner.setTelephone(telephone);
        assertEquals(telephone, this.owner.getTelephone());
    }

    @Test
    public void testSetTelephoneWithNull() {
        String telephone = null;
        this.owner.setTelephone(telephone);
        assertEquals(telephone, this.owner.getTelephone());
    }
}
