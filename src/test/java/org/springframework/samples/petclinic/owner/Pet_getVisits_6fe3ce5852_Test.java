package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Pet_getVisits_6fe3ce5852_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Visit visit1;

    @InjectMocks
    private Visit visit2;

    @BeforeEach
    public void setup() {
        visit1 = new Visit();
        visit2 = new Visit();
        Set<Visit> visits = new HashSet<>(Arrays.asList(visit1, visit2));
        when(pet.getVisits()).thenReturn(visits);
    }

    @Test
    public void testGetVisitsSuccess() {
        Set<Visit> visits = pet.getVisits();
        assertEquals(2, visits.size());
        assertEquals(true, visits.contains(visit1));
        assertEquals(true, visits.contains(visit2));
    }

    @Test
    public void testGetVisitsFailure() {
        Set<Visit> visits = pet.getVisits();
        Visit visit3 = new Visit();
        assertEquals(false, visits.contains(visit3));
    }
}
