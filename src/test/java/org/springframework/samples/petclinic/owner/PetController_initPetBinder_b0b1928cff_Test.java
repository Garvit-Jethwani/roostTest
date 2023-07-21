package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

public class PetController_initPetBinder_b0b1928cff_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    WebDataBinder dataBinder = new WebDataBinder();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);
        verify(dataBinder, times(1)).setValidator(any(PetValidator.class));
    }

    @Test
    public void testInitPetBinderWithNullDataBinder() {
        petController.initPetBinder(null);
        verify(dataBinder, times(0)).setValidator(any(PetValidator.class));
    }
}
