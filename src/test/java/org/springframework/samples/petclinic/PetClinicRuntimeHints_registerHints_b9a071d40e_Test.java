package org.springframework.samples.petclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class PetClinicRuntimeHints_registerHints_b9a071d40e_Test {

    @Mock
    private RuntimeHints runtimeHints;

    private PetClinicRuntimeHints_registerHints_b9a071d40e petClinicRuntimeHints;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        petClinicRuntimeHints = new PetClinicRuntimeHints_registerHints_b9a071d40e();
    }

    @Test
    public void testRegisterHints() {
        petClinicRuntimeHints.registerHints(runtimeHints, Thread.currentThread().getContextClassLoader());

        verify(runtimeHints.resources()).registerPattern("db/*");
        verify(runtimeHints.resources()).registerPattern("messages/*");
        verify(runtimeHints.resources()).registerPattern("META-INF/resources/webjars/*");
        verify(runtimeHints.resources()).registerPattern("mysql-default-conf");
        verify(runtimeHints.serialization()).registerType(BaseEntity.class);
        verify(runtimeHints.serialization()).registerType(Person.class);
        verify(runtimeHints.serialization()).registerType(Vet.class);
    }

    @Test
    public void testRegisterHints_withNullHints() {
        try {
            petClinicRuntimeHints.registerHints(null, Thread.currentThread().getContextClassLoader());
        } catch (NullPointerException e) {
            assertEquals("RuntimeHints cannot be null", e.getMessage());
        }
    }
}
