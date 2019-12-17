package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDataAccessObject {

    private DataStore dataStore;

    public UserDataAccessObject(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    /**
     * Find a user by user id
     * @param userId
     * @return
     */
    public User findUserById(int userId){
        Optional<User> user = dataStore.getUsers().stream().filter(u-> u.getId() == userId).findFirst();
        return (user.isPresent()) ?  user.get() : null;

    }

    /**
     * find list of users for given list of roleIds
     * @param roleIds
     * @return
     */
    public List<User> findAllUsersByRoles(List<Integer> roleIds){
        if(roleIds == null) return null;
        List<User> users = dataStore.getUsers();
        return users.stream().filter(user -> roleIds.contains(user.getRoleId())).collect(Collectors.toList());
    }
}
