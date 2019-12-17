package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.Role;
import com.deputy.assignment.model.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DataStoreTest {
    DataStore dataStore =  DataStore.getInstance();

    @Test
    public void should_load_users_successfully() {

        dataStore.setUsers(DataGenerator.loadUserData());
        assertEquals(5, dataStore.getUsers().size());
    }

    @Test
    public void should_load_roles_successfully() {

        dataStore.setRoles(DataGenerator.loadRoleData());
        assertEquals(5, dataStore.getRoles().size());
    }
}