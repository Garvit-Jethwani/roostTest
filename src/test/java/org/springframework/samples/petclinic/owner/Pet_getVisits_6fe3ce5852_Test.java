package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Pet_getVisits_6fe3ce5852_Test {

    @InjectMocks
    Pet pet;

    @Mock
    Visit visit1, visit2;

    @BeforeEach
    void setup() {
        pet.addVisit(visit1);
        pet.addVisit(visit2);
    }

    @Test
    public void testGetVisits_Success() {
        Collection<Visit> visits = Arrays.asList(visit1, visit2);
        when(pet.getVisits()).thenReturn(visits);

        Collection<Visit> actualVisits = pet.getVisits();
        assertEquals(visits, actualVisits);
    }

    @Test
    public void testGetVisits_Empty() {
        Pet pet = new Pet();
        assertEquals(0, pet.getVisits().size());
    }
}
