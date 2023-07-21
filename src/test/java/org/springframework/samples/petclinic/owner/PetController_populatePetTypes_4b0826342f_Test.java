package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.PetType;

public class PetController_populatePetTypes_4b0826342f_Test {

    @Mock
    private OwnerService owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
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
    public void testPopulatePetTypes_empty() {
        when(owners.findPetTypes()).thenReturn(Arrays.asList());

        Collection<PetType> petTypes = petController.populatePetTypes();

        assertEquals(0, petTypes.size());
    }
}
