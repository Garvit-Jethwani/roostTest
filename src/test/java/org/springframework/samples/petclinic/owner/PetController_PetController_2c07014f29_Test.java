package org.springframework.samples.petclinic.owner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PetController_PetController_2c07014f29_Test {

    @InjectMocks
    PetController petController;
    
    @Mock
    OwnerRepository owners;
    
    @Before
    public void init() {
        petController = new PetController();
    }
    
    @Test
    public void testPetControllerConstructor_withValidOwnerRepository() {
        OwnerRepository ownerRepository = mock(OwnerRepository.class);
        PetController petController = new PetController();
        assertEquals(ownerRepository, petController.getOwners());
    }
    
    @Test(expected = NullPointerException.class)
    public void testPetControllerConstructor_withNullOwnerRepository() {
        PetController petController = new PetController();
    }
}
