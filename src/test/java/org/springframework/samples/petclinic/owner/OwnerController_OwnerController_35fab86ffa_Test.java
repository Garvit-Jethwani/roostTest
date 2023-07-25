package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController_OwnerController_35fab86ffa_Test {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOwnerController() {
        OwnerController testOwnerController = new OwnerController();
        assertEquals(testOwnerController.getOwnerRepository(), ownerRepository);
    }

    @Test
    public void testOwnerControllerWhenOwnerRepositoryIsNull() {
        OwnerController testOwnerController = new OwnerController();
        assertEquals(testOwnerController.getOwnerRepository(), null);
    }
}
