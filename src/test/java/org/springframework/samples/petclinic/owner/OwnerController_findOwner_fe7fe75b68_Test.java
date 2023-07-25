package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.mockito.Mockito.when;

public class OwnerController_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindOwnerWithNullId() {
        Owner owner = ownerController.findOwner(null);
        Assertions.assertNotNull(owner, "Owner should not be null");
    }

    @Test
    public void testFindOwnerWithValidId() {
        Integer ownerId = 1;
        Owner expectedOwner = new Owner();
        expectedOwner.setId(ownerId);

        when(ownerRepository.findById(ownerId)).thenReturn(java.util.Optional.ofNullable(expectedOwner));

        Owner actualOwner = ownerController.findOwner(ownerId);
        Assertions.assertEquals(expectedOwner, actualOwner, "Owners should be equal");
    }
}
