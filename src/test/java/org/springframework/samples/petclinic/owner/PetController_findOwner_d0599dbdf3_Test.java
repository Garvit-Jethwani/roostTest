package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_findOwner_d0599dbdf3_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    void testFindOwnerSuccess() {
        when(owners.findById(1)).thenReturn(owner);

        Owner actualOwner = petController.findOwner(1);

        assertEquals(owner, actualOwner);
    }

    @Test
    void testFindOwnerFailure() {
        when(owners.findById(1)).thenReturn(null);

        Owner actualOwner = petController.findOwner(1);

        assertEquals(null, actualOwner);
    }
}
