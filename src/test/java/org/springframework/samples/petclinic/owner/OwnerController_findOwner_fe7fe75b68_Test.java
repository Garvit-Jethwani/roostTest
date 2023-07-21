package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testFindOwnerWithId() {
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));
        Owner actualOwner = ownerController.findOwner(1);
        assertNotNull(actualOwner, "Owner should not be null");
        assertEquals(owner.getId(), actualOwner.getId(), "Ids should match");
        assertEquals(owner.getFirstName(), actualOwner.getFirstName(), "First names should match");
        assertEquals(owner.getLastName(), actualOwner.getLastName(), "Last names should match");
    }

    @Test
    public void testFindOwnerWithoutId() {
        Owner actualOwner = ownerController.findOwner(null);
        assertNotNull(actualOwner, "Owner should not be null");
        assertEquals(new Owner().getId(), actualOwner.getId(), "Ids should match");
        assertEquals(new Owner().getFirstName(), actualOwner.getFirstName(), "First names should match");
        assertEquals(new Owner().getLastName(), actualOwner.getLastName(), "Last names should match");
    }
}
