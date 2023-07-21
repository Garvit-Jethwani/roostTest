package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPaginatedForOwnersLastName() {
        String lastname = "Smith";
        int page = 1;
        int pageSize = 5;
        List<Owner> ownerList = Stream.generate(Owner::new).limit(pageSize).collect(Collectors.toList());
        Page<Owner> ownerPage = new PageImpl<>(ownerList);
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        
        when(owners.findByLastName(lastname, pageable)).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);

        assertEquals(ownerPage, result);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_Empty() {
        String lastname = "Smith";
        int page = 1;
        int pageSize = 5;
        List<Owner> ownerList = Stream.generate(Owner::new).limit(0).collect(Collectors.toList());
        Page<Owner> ownerPage = new PageImpl<>(ownerList);
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        
        when(owners.findByLastName(lastname, pageable)).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);

        assertEquals(ownerPage, result);
    }
}
