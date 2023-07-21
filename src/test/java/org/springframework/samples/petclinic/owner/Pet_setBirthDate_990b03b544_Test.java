package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class Pet_setBirthDate_990b03b544_Test {

    private Pet pet;

    @BeforeEach
    void setup() {
        pet = new Pet();
    }

    @Test
    void testSetBirthDateWithValidDate() {
        LocalDate validBirthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(validBirthDate);
        Assertions.assertEquals(validBirthDate, pet.getBirthDate());
    }

    @Test
    void testSetBirthDateWithNull() {
        pet.setBirthDate(null);
        Assertions.assertNull(pet.getBirthDate());
    }
}
