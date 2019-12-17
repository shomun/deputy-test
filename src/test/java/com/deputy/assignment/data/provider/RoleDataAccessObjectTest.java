package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoleDataAccessObjectTest {

    private RoleDataAccessObject classUderTest;

    private  DataStore dataStore = mock(DataStore.class);



    @BeforeEach
    void setUp() {
        classUderTest = new RoleDataAccessObject(dataStore);
        when(dataStore.getRoles()).thenReturn(DataGenerator.loadRoleData());
    }

    @Test
    void should_return_role_Admin() {
        Role role = classUderTest.findRoleById(1);

        assertNotNull(role);
        assertEquals("System Administrator",role.getName());

    }

    @Test
    void should_return_no_role() {
        Role role = classUderTest.findRoleById(11);
         assertNull(role);
    }


    @Test
    void should_return_4_subroles_of_Admin() {
        List<Role> subroles = classUderTest.findSubRolesByParentId(1);

        assertNotNull(subroles);
        assertEquals(4,subroles.size());

    }

    @Test
    void should_return_2_subroles_of_Supervisor() {
        List<Role> subroles = classUderTest.findSubRolesByParentId(3);

        assertNotNull(subroles);
        assertEquals(2,subroles.size());

    }

    @Test
    void should_return_no_subroles_of_Employee() {
        List<Role> subroles = classUderTest.findSubRolesByParentId(4);

        assertNotNull(subroles);
        //assertEquals(2,subroles.size());

    }
}