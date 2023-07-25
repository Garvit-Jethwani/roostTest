package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.visit.Visit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class Pet_addVisit_99c71f5c31_Test {

    @InjectMocks
    private Pet pet;

    @Mock
    private Visit visit;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        pet = new Pet();
        visit = new Visit();
    }

    @Test
    public void testAddVisit() {
        pet.addVisit(visit);
        verify(visit, times(1)).setPet(any(Pet.class));
        assertTrue(pet.getVisits().contains(visit));
    }

    @Test
    public void testAddVisitWithNull() {
        Exception exception = null;
        try {
            pet.addVisit(null);
        } catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NullPointerException);
    }
}
