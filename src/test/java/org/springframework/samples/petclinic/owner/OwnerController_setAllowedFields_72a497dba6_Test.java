package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @Mock
    private WebDataBinder dataBinder;

    @InjectMocks
    private OwnerController ownerController = new OwnerController();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithDifferentField() {
        // TODO: Change the field to be disallowed
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("anotherField");
    }
}
