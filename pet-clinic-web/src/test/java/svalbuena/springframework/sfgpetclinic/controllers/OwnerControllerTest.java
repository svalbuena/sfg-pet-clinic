package svalbuena.springframework.sfgpetclinic.controllers;

import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import svalbuena.springframework.sfgpetclinic.model.Owner;
import svalbuena.springframework.sfgpetclinic.services.OwnerService;

import java.util.Set;

import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    private static final Set<Owner> OWNERS = ImmutableSet.of(givenOwner(1), givenOwner(2));

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll())
                .thenReturn(OWNERS);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", contains(OWNERS.toArray())));
    }

    @Test
    void findOwners() {

    }

    private static Owner givenOwner(final long id) {
        final Owner owner = new Owner("FIRST_NAME", "LAST_NAME", "ADDRESS", "CITY", "TELEPHONE");
        owner.setId(id);
        return owner;
    }
}