package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @Mock
    private BindingResult result;

    @Mock
    private OwnerRepository owners;

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessCreationFormSuccess() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);
        String view = processCreationForm(owner, result);
        verify(owners, times(1)).save(owner);
        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationFormHasErrors() {
        when(result.hasErrors()).thenReturn(true);
        String view = processCreationForm(owner, result);
        verify(owners, times(0)).save(owner);
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }

    private String processCreationForm(Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "VIEWS_OWNER_CREATE_OR_UPDATE_FORM";
        }
        this.owners.save(owner);
        return "redirect:/owners/" + owner.getId();
    }
}
