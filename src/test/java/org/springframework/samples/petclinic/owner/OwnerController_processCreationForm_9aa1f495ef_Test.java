package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Mock
    BindingResult result;

    @Mock
    Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessCreationForm_success() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);

        String view = ownerController.processCreationForm(owner, result);

        verify(owners, times(1)).save(owner);
        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_failure() {
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processCreationForm(owner, result);

        verify(owners, times(0)).save(owner);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
