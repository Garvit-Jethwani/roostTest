package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetController_initOwnerBinder_ae5e2b131f_Test {

    @Test
    public void testInitOwnerBinder_disallowedFieldId() {
        WebDataBinder dataBinder = mock(WebDataBinder.class);
        PetController petController = new PetController();

        petController.initOwnerBinder(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinder_allowedFieldNotId() {
        WebDataBinder dataBinder = mock(WebDataBinder.class);
        PetController petController = new PetController();

        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, never()).setDisallowedFields("notId");
    }
}
