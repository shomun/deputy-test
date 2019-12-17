package com.deputy.assignment;

import com.deputy.assignment.model.User;
import com.deputy.assignment.service.RoleService;
import com.deputy.assignment.service.UserService;

import java.util.List;

public class UserController {

    private RoleService roleService;

    private UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    public List<User> getSubOrdinates(int userId){

        return userService.getSubOrdinates(userId);

    }
}
