package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class Owner_addVisit_e85a2eeaa5_Test {
    @Mock
    Pet pet;

    @InjectMocks
    Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddVisit() {
        Visit visit = new Visit();
        when(owner.getPet(anyInt())).thenReturn(pet);
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, new Visit());
        });
    }

    @Test
    public void testAddVisitWithNullVisit() {
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, null);
        });
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        when(owner.getPet(anyInt())).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, new Visit());
        });
    }
}
