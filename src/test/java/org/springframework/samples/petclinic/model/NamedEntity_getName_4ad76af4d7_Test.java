package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NamedEntity_getName_4ad76af4d7_Test {

    @Mock
    private NamedEntity namedEntity;

    @Before
    public void setUp() {
        when(namedEntity.getName()).thenReturn("TestName");
    }

    @Test
    public void testGetName_Success() {
        String name = namedEntity.getName();
        assertEquals("TestName", name);
    }

    @Test
    public void testGetName_Failure() {
        String name = namedEntity.getName();
        assertNotEquals("WrongName", name);
    }
}
