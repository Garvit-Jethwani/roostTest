package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getCity_fc0393fa80_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testGetCityWhenCityIsSet() {
        String expectedCity = "New York";
        owner.setCity(expectedCity);
        String actualCity = owner.getCity();
        assertEquals(expectedCity, actualCity, "Expected city does not match actual city");
    }

    @Test
    public void testGetCityWhenCityIsNotSet() {
        String actualCity = owner.getCity();
        assertEquals(null, actualCity, "Expected city to be null as it is not set");
    }
}
