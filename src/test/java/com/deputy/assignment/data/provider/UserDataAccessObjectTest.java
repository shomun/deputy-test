package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDataAccessObjectTest {

    private UserDataAccessObject classUderTest;

    private  DataStore dataStore = mock(DataStore.class);



    @BeforeEach
    void setUp() {

       classUderTest = new UserDataAccessObject(dataStore);
        when(dataStore.getUsers()).thenReturn(DataGenerator.loadUserData());
    }

    @Test
    void should_findUserById_successfully() {
        User user  = classUderTest.findUserById(1);
        assertNotNull(user);
        assertEquals("Adam Admin", user.getName());

    }

    @Test
    void should_not_findUserById() {
        User user  = classUderTest.findUserById(11);
        assertNull(user);

    }

    @Test
    void findAllUsersByRoles_should_find_2_users_successfully() {
        List<Integer> subRoleIds = new ArrayList<>();
        subRoleIds.add(4);
        subRoleIds.add(5);
        List<User> users  = classUderTest.findAllUsersByRoles(subRoleIds);
        assertNotNull(users);
        assertEquals(2, users.size());

    }

    @Test
    void findAllUsersByRoles_should_find_3_users_successfully() {
        List<Integer> subRoleIds = new ArrayList<>();
        subRoleIds.add(3);
        subRoleIds.add(4);
        subRoleIds.add(5);
        List<User> users  = classUderTest.findAllUsersByRoles(subRoleIds);
        assertNotNull(users);
        assertEquals(3, users.size());

    }
}
