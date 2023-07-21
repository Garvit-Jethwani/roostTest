package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner_addVisit_e85a2eeaa5_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    private Visit visit;

    @BeforeEach
    void setUp() {
        visit = new Visit();
    }

    @Test
    void testAddVisitSuccess() {
        doNothing().when(pet).addVisit(visit);
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    void testAddVisitWithNullPetId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> owner.addVisit(null, visit));
        assertEquals("Pet identifier must not be null!", exception.getMessage());
    }

    @Test
    void testAddVisitWithNullVisit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> owner.addVisit(1, null));
        assertEquals("Visit must not be null!", exception.getMessage());
    }

    @Test
    void testAddVisitWithInvalidPetId() {
        when(owner.getPet(99)).thenReturn(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> owner.addVisit(99, visit));
        assertEquals("Invalid Pet identifier!", exception.getMessage());
    }
}
