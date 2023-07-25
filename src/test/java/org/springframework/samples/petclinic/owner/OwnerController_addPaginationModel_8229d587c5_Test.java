package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @Mock
    private Model model;

    @Mock
    private Page<Owner> paginated;

    private OwnerController ownerController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
    }

    @Test
    public void testAddPaginationModel() {
        int page = 1;
        List<Owner> listOwners = Arrays.asList(new Owner(), new Owner());
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn((long) listOwners.size());

        String view = ownerController.addPaginationModel(page, model, paginated);

        verify(model).addAttribute("listOwners", paginated);
        verify(model).addAttribute("currentPage", page);
        verify(model).addAttribute("totalPages", paginated.getTotalPages());
        verify(model).addAttribute("totalItems", paginated.getTotalElements());
        verify(model).addAttribute("listOwners", listOwners);
        assertEquals("owners/ownersList", view);
    }

    @Test
    public void testAddPaginationModelWithNoOwners() {
        int page = 1;
        List<Owner> listOwners = Arrays.asList();
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn((long) listOwners.size());

        String view = ownerController.addPaginationModel(page, model, paginated);

        verify(model).addAttribute("listOwners", paginated);
        verify(model).addAttribute("currentPage", page);
        verify(model).addAttribute("totalPages", paginated.getTotalPages());
        verify(model).addAttribute("totalItems", paginated.getTotalElements());
        verify(model).addAttribute("listOwners", listOwners);
        assertEquals("owners/ownersList", view);
    }
}
