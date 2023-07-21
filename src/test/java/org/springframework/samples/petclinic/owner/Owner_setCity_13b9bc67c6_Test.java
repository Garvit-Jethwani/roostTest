package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Owner_setCity_13b9bc67c6_Test {

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
    }

    @Test
    public void testSetCity_withValidCity() {
        String validCity = "New York";
        owner.setCity(validCity);
        assertEquals(validCity, owner.getCity());
    }

    @Test
    public void testSetCity_withNullCity() {
        String nullCity = null;
        owner.setCity(nullCity);
        assertNull(owner.getCity());
    }
}
