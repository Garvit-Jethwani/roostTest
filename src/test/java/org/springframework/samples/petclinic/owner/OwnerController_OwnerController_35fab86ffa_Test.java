package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerRepository owners;
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        owners = Mockito.mock(OwnerRepository.class);
        ownerController = new OwnerController();
    }

    @Test
    public void testOwnerControllerConstructor_Success() {
        assertNotNull(ownerController);
    }

    @Test
    public void testOwnerControllerConstructor_Failure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new OwnerController();
        });
        assertEquals("OwnerRepository cannot be null", exception.getMessage());
    }
}
