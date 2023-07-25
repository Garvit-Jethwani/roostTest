package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner_getTelephone_d5dc76821d_Test {

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        owner.setTelephone("1234567890");
    }

    @Test
    public void testGetTelephone() {
        String telephone = owner.getTelephone();
        assertEquals("1234567890", telephone);
    }

    @Test
    public void testGetTelephone_Failure() {
        owner.setTelephone(null);
        String telephone = owner.getTelephone();
        assertEquals(null, telephone);
    }
}
