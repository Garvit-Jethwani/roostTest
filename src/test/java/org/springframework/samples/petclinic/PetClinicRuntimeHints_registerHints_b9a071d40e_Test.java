package org.springframework.samples.petclinic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PetClinicRuntimeHints_registerHints_b9a071d40e_Test {

    @Mock
    private RuntimeHints hints;

    @Mock
    private ClassLoader classLoader;

    @InjectMocks
    private PetClinicRuntimeHints_registerHints_b9a071d40e petClinicRuntimeHints;

    @Before
    public void setUp() {
        petClinicRuntimeHints = new PetClinicRuntimeHints_registerHints_b9a071d40e();
    }

    @Test
    public void testRegisterHints() {
        // Call the method to test
        petClinicRuntimeHints.registerHints(hints, classLoader);

        // Verify the interactions with the mock objects
        verify(hints, times(1)).resources().registerPattern("db/*");
        verify(hints, times(1)).resources().registerPattern("messages/*");
        verify(hints, times(1)).resources().registerPattern("META-INF/resources/webjars/*");
        verify(hints, times(1)).resources().registerPattern("mysql-default-conf");
        verify(hints, times(1)).serialization().registerType(BaseEntity.class);
        verify(hints, times(1)).serialization().registerType(Person.class);
        verify(hints, times(1)).serialization().registerType(Vet.class);
    }
}
