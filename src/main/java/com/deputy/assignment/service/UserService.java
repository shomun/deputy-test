package com.deputy.assignment.service;

import com.deputy.assignment.data.provider.UserDataAccessObject;
import com.deputy.assignment.model.User;

import java.util.List;


public class UserService {


    private RoleService roleService;

    private UserDataAccessObject userDataAccessObject;

    public UserService(RoleService roleService, UserDataAccessObject userDataAccessObject) {
        this.roleService = roleService;
        this.userDataAccessObject = userDataAccessObject;
    }

    /**
     * Find all subordinates for a given user id
     * @param userId
     * @return
     */
    public List<User> getSubOrdinates(int userId){
        List<User> subordinates = null;
        User user = userDataAccessObject.findUserById(userId);
        if(user != null){
            List<Integer> subRoleIds = roleService.getSubRolesByParentId(user.getRoleId());
            subordinates =  userDataAccessObject.findAllUsersByRoles(subRoleIds);
        }
        return subordinates;
    }
}
