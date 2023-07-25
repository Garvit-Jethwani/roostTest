package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collection;

public class PetController_populatePetTypes_4b0826342f_Test {

    @Mock
    private OwnerRepository owners;

    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.petController = new PetController();
    }

    @Test
    public void testPopulatePetTypes() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");
        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(2, petTypes.size());
    }

    @Test
    public void testPopulatePetTypes_Empty() {
        when(owners.findPetTypes()).thenReturn(Arrays.asList());
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(0, petTypes.size());
    }
}
