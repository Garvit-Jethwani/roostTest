package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_setId_58357d9c06_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetId_positiveNumber() {
        Integer expectedId = 10;
        baseEntity.setId(expectedId);
        assertEquals(expectedId, baseEntity.getId());
    }

    @Test
    public void testSetId_zero() {
        Integer expectedId = 0;
        baseEntity.setId(expectedId);
        assertEquals(expectedId, baseEntity.getId());
    }

    @Test
    public void testSetId_nullValue() {
        baseEntity.setId(null);
        assertEquals(null, baseEntity.getId());
    }
}
