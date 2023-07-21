package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_initCreationForm_b0b57b1f82_Test {

    @Mock
    private Owner owner;

    @Mock
    private ModelMap model;

    @InjectMocks
    private PetController petController;

    private Pet pet;

    @BeforeEach
    public void setUp() {
        pet = new Pet();
        when(owner.addPet(pet)).thenReturn(true);
    }

    @Test
    public void testInitCreationFormSuccess() {
        String view = petController.initCreationForm(owner, model);
        verify(owner).addPet(pet);
        verify(model).put("pet", pet);
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testInitCreationFormFailure() {
        when(owner.addPet(pet)).thenReturn(false);
        String view = petController.initCreationForm(owner, model);
        verify(owner).addPet(pet);
        assertEquals("redirect:/oups", view);
    }
}
