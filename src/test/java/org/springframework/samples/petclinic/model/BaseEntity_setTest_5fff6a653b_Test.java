package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseEntityTest {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetId_Success() {
        Integer expectedValue = 1;
        baseEntity.setId(expectedValue);
        assertEquals(expectedValue, baseEntity.getId());
    }

    @Test
    public void testSetId_Null() {
        Integer expectedValue = null;
        baseEntity.setId(expectedValue);
        assertEquals(expectedValue, baseEntity.getId());
    }
}
