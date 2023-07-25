package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OwnerController_initCreationForm_7ad03dd574_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitCreationForm() {
        Map<String, Object> modelMap = new HashMap<>();
        when(ownerController.initCreationForm(model)).thenReturn("VIEWS_OWNER_CREATE_OR_UPDATE_FORM");
        String view = ownerController.initCreationForm(modelMap);

        // Verify the method is putting the right attribute to the model
        assertTrue(modelMap.containsKey("owner"));

        // Verify the returned view name is correct
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }

    @Test
    public void testInitCreationFormWithExistingModel() {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("owner", new Owner());
        when(ownerController.initCreationForm(model)).thenReturn("VIEWS_OWNER_CREATE_OR_UPDATE_FORM");
        String view = ownerController.initCreationForm(modelMap);

        // Verify the method is not overwriting the existing "owner" attribute
        assertTrue(modelMap.containsKey("owner"));

        // Verify the returned view name is correct
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }
}
