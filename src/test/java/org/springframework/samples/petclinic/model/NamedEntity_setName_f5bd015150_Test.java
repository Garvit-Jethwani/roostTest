package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = Mockito.mock(NamedEntity.class);
    }

    @Test
    public void testSetName_Success() {
        String expectedName = "TestName";
        Mockito.doAnswer(invocation -> {
            String name = invocation.getArgument(0);
            assertEquals(expectedName, name);
            return null;
        }).when(namedEntity).setName(expectedName);

        namedEntity.setName(expectedName);
    }

    @Test
    public void testSetName_Null() {
        String expectedName = null;
        Mockito.doAnswer(invocation -> {
            String name = invocation.getArgument(0);
            assertEquals(expectedName, name);
            return null;
        }).when(namedEntity).setName(expectedName);

        namedEntity.setName(expectedName);
    }
}
