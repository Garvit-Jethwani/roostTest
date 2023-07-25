package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseEntity_isNew_70b8047511_Test {

    private BaseEntity baseEntity;

    @Before
    public void setUp() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testIsNew_withNullId() {
        this.baseEntity.setId(null);
        assertTrue(this.baseEntity.isNew());
    }

    @Test
    public void testIsNew_withNonNullId() {
        this.baseEntity.setId(1);
        assertTrue(this.baseEntity.isNew());
    }
}
