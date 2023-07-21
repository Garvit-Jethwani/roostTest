package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

public class PetController_processCreationForm_c3fe45c8ee_Test {

    @InjectMocks
    PetController petController;

    @Mock
    Owner owner;

    @Mock
    Pet pet;

    @Mock
    BindingResult result;

    @Mock
    ModelMap model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessCreationFormWithNameDuplicate() {
        when(pet.getName()).thenReturn("Rex");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Rex", true)).thenReturn(pet);

        String view = petController.processCreationForm(owner, pet, result, model);

        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessCreationFormWithFutureBirthDate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processCreationForm(owner, pet, result, model);

        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessCreationFormSuccess() {
        when(pet.getName()).thenReturn("Rex");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Rex", true)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now());
        when(result.hasErrors()).thenReturn(false);

        String view = petController.processCreationForm(owner, pet, result, model);

        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
