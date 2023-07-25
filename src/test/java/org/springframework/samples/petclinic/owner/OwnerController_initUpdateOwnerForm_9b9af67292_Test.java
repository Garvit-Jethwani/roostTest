package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initUpdateOwnerForm_9b9af67292_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    private OwnerController controller;

    @BeforeEach
    public void setup() {
        controller = new OwnerController();
        controller.setOwnerRepository(owners);
    }

    @Test
    public void testInitUpdateOwnerForm_validOwner() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);

        String viewName = controller.initUpdateOwnerForm(1, model);

        assertThat(viewName).isEqualTo("owners/createOrUpdateOwnerForm");
        Mockito.verify(model).addAttribute("owner", owner);
    }

    @Test
    public void testInitUpdateOwnerForm_invalidOwner() {
        when(owners.findById(1)).thenReturn(null);

        String viewName = controller.initUpdateOwnerForm(1, model);

        assertThat(viewName).isEqualTo("owners/createOrUpdateOwnerForm");
        Mockito.verify(model, Mockito.never()).addAttribute(Mockito.anyString(), Mockito.any());
    }
}
