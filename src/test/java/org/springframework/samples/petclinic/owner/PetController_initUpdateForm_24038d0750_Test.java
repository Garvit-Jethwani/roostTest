package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initUpdateForm_24038d0750_Test {

    private Owner owner;
    private ModelMap model;
    private PetController controller;

    @BeforeEach
    public void setup() {
        owner = mock(Owner.class);
        model = new ModelMap();
        controller = new PetController();
    }

    @Test
    public void testInitUpdateForm_validPetId() {
        Pet pet = new Pet();
        when(owner.getPet(1)).thenReturn(pet);

        String view = controller.initUpdateForm(owner, 1, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(pet, model.get("pet"));
    }

    @Test
    public void testInitUpdateForm_invalidPetId() {
        when(owner.getPet(2)).thenReturn(null);

        String view = controller.initUpdateForm(owner, 2, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(null, model.get("pet"));
    }
}
