package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @Mock
    WebDataBinder dataBinder;

    @InjectMocks
    OwnerController ownerController;

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsFailure() {
        try {
            ownerController.setAllowedFields(null);
        } catch (Exception e) {
            assertEquals("WebDataBinder object cannot be null", e.getMessage());
        }
    }
}
