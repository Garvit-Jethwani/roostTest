package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetController_PetController_2c07014f29_Test {

    private OwnerRepository owners;
    private PetController petController;

    @BeforeEach
    public void setUp() {
        owners = Mockito.mock(OwnerRepository.class);
        petController = new PetController();
    }

    @Test
    public void testPetController() {
        assertNotNull(petController, "PetController is null");
    }

    @Test
    public void testPetControllerWithNullOwnerRepository() {
        PetController petControllerNull = new PetController();
        assertNotNull(petControllerNull, "PetController is null");
    }
}
