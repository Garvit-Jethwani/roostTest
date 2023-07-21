package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.samples.petclinic.owner.Owner;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_addPaginationModel_8229d587c5_Test {

    @Test
    public void testAddPaginationModel_Success() {
        // Arrange
        Model model = Mockito.mock(Model.class);
        Page<Owner> paginated = Mockito.mock(Page.class);
        int page = 1;
        List<Owner> listOwners = Arrays.asList(new Owner(), new Owner());
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn(10L);
        OwnerController controller = new OwnerController();

        // Act
        String result = controller.addPaginationModel(page, model, paginated);

        // Assert
        assertEquals("owners/ownersList", result);
    }

    @Test
    public void testAddPaginationModel_EmptyList() {
        // Arrange
        Model model = Mockito.mock(Model.class);
        Page<Owner> paginated = Mockito.mock(Page.class);
        int page = 1;
        List<Owner> listOwners = Arrays.asList();
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);
        OwnerController controller = new OwnerController();

        // Act
        String result = controller.addPaginationModel(page, model, paginated);

        // Assert
        assertEquals("owners/ownersList", result);
    }
}
