package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class OwnerController_showOwner_b133e53184_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    public void testShowOwner_ValidOwner() throws Exception {
        Owner mockOwner = new Owner();
        mockOwner.setId(1);
        when(owners.findById(anyInt())).thenReturn(mockOwner);

        mockMvc.perform(get("/owners/{ownerId}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"));

        verify(owners).findById(1);

        ModelAndView mav = ownerController.showOwner(1);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(mockOwner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_InvalidOwner() throws Exception {
        when(owners.findById(anyInt())).thenReturn(null);

        mockMvc.perform(get("/owners/{ownerId}", 999))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"));

        verify(owners).findById(999);

        ModelAndView mav = ownerController.showOwner(999);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
