package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class PetController_initPetBinder_b0b1928cff_Test {

    @Mock
    private WebDataBinder dataBinder;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(new PetValidator());
    }

    @Test
    public void testPetValidator() {
        PetValidator petValidator = new PetValidator();
        Pet pet = new Pet();
        pet.setName("Max");
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(0, errors.getErrorCount());
    }

    @Test
    public void testPetValidatorWithNullName() {
        PetValidator petValidator = new PetValidator();
        Pet pet = new Pet();
        pet.setName(null);
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
    }
}
