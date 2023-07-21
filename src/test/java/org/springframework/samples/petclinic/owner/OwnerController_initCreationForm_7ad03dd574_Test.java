package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

public class OwnerController_initCreationForm_7ad03dd574_Test {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private OwnerController ownerController;
    private Map<String, Object> model;

    @BeforeEach
    public void setup() {
        // You might need to inject some dependencies into the OwnerController here
        ownerController = new OwnerController();
        model = new HashMap<>();
    }

    @Test
    public void testInitCreationForm_Success() {
        String view = ownerController.initCreationForm(model);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
        assertEquals(new Owner(), model.get("owner"));
    }

    @Test
    public void testInitCreationForm_NullModel() {
        String view = ownerController.initCreationForm(null);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
    }
}
