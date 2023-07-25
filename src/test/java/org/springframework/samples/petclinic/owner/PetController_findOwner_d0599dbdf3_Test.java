package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_findOwner_d0599dbdf3_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwner_success() {
        when(owners.findById(1)).thenReturn(owner);

        Owner actualOwner = petController.findOwner(1);
        assertNotNull(actualOwner, "Owner should not be null");
        assertEquals(owner.getId(), actualOwner.getId(), "Owner ids should match");
        assertEquals(owner.getFirstName(), actualOwner.getFirstName(), "Owner first names should match");
        assertEquals(owner.getLastName(), actualOwner.getLastName(), "Owner last names should match");
    }

    @Test
    public void testFindOwner_failure() {
        when(owners.findById(1)).thenReturn(null);

        Owner actualOwner = petController.findOwner(1);
        assertNull(actualOwner, "Owner should be null");
    }
}
