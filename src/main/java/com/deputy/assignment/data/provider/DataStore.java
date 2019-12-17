package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.Role;
import com.deputy.assignment.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * It is an in-memory data store to store user and role data
 * A singleton instance of this class is used throughout the life-cycle of the application
 */
@Data
public class DataStore {

    private List<Role> roles;

    private List<User> users;

    private static DataStore instance;
    static {
        instance = new DataStore();
    }

    private DataStore(){
        roles = new ArrayList<>();
        users = new ArrayList<>();
    }

    /**
     * Get an instance
     * @return
     */
    public static DataStore getInstance(){
        return instance;
    }

}
