package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BaseEntityTest {

    @InjectMocks
    BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetId() {
        Integer expectedValue = 1;
        baseEntity.setId(expectedValue);
        Integer actualValue = baseEntity.getId();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetIdWithNull() {
        baseEntity.setId(null);
        Integer actualValue = baseEntity.getId();
        Assertions.assertNull(actualValue);
    }
}
