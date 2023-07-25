package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        this.baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdSuccess() {
        Integer expectedId = 1;
        this.baseEntity.setId(expectedId);
        Integer actualId = this.baseEntity.getId();
        assertEquals(expectedId, actualId, "The ID returned by getId method does not match the expected ID");
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        Integer expectedId = null;
        this.baseEntity.setId(expectedId);
        Integer actualId = this.baseEntity.getId();
        assertEquals(expectedId, actualId, "The ID returned by getId method does not match the expected ID");
    }
}
