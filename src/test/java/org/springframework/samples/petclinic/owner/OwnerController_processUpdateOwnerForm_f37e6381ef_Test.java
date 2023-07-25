package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_success() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");

        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(1)).save(any(Owner.class));
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_failure() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");

        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(0)).save(any(Owner.class));
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }
}
