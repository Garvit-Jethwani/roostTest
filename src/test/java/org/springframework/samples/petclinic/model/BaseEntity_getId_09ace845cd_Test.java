package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = Mockito.mock(BaseEntity.class);
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        Mockito.when(baseEntity.getId()).thenReturn(null);
        Integer id = baseEntity.getId();
        assertNull(id, "Expected id to be null");
    }

    @Test
    public void testGetIdWhenIdIsNotNull() {
        Integer expectedId = 1;
        Mockito.when(baseEntity.getId()).thenReturn(expectedId);
        Integer id = baseEntity.getId();
        assertEquals(expectedId, id, "Expected id to be " + expectedId);
    }
}
