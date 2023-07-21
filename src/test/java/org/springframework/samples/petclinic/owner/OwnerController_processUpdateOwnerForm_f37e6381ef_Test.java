package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        Owner owner = new Owner();
        owner.setId(1);

        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(1)).save(any(Owner.class));
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_HasErrors() {
        Owner owner = new Owner();
        owner.setId(1);

        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(0)).save(any(Owner.class));
        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
