package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Pet;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        this.pet = new Pet();
    }

    @Test
    public void testGetBirthDate_WhenBirthDateIsSet() {
        LocalDate expectedBirthDate = LocalDate.now();
        this.pet.setBirthDate(expectedBirthDate);

        LocalDate actualBirthDate = this.pet.getBirthDate();

        assertEquals(expectedBirthDate, actualBirthDate, 
            "The expected birth date does not match the actual birth date.");
    }

    @Test
    public void testGetBirthDate_WhenBirthDateIsNotSet() {
        LocalDate actualBirthDate = this.pet.getBirthDate();

        assertNull(actualBirthDate, "The birth date should be null as it is not set.");
    }
}
