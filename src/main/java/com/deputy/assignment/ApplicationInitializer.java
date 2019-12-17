package com.deputy.assignment;


import com.deputy.assignment.data.provider.DataStore;
import com.deputy.assignment.data.provider.RoleDataAccessObject;
import com.deputy.assignment.data.provider.UserDataAccessObject;
import com.deputy.assignment.model.Role;
import com.deputy.assignment.model.User;
import com.deputy.assignment.service.RoleService;
import com.deputy.assignment.service.UserService;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * A Helper class to initialize all the components required for this application
 * It also loads data from given json files
 */
public class ApplicationInitializer {
    private String userDataFileName;
    private String roleDataFileName;

    private UserController userController;
    private UserService userService;
    private RoleService roleService;

    private Gson gson = new Gson();

    public ApplicationInitializer(String userDataFileName, String roleDataFileName) {
        this.userDataFileName = userDataFileName;
        this.roleDataFileName = roleDataFileName;
    }

    public UserController getUserController(){
        return userController;
    }

    public void init(){
        DataStore dataStore = DataStore.getInstance();
        RoleService roleService = initRoleService();
        UserService userService = initUserService(roleService);
        userController = new UserController(roleService,userService);

        initRoleData();
        initUserData();
    }

    private void initUserData() {
        String userData =  getDataFromFile(userDataFileName);

        User[] users = gson.fromJson(userData, User[].class);

        DataStore.getInstance().setUsers(Arrays.asList(users));
    }

    private String getDataFromFile(String fileName) {
        String data = null;
        try {
            data = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return data;
    }

    private RoleService initRoleService() {
        RoleDataAccessObject roleDataAccessObject = new RoleDataAccessObject(DataStore.getInstance());
        return new RoleService(roleDataAccessObject);
    }

    private UserService initUserService(RoleService roleService) {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(DataStore.getInstance());
        return new UserService(roleService,userDataAccessObject);
    }

    private void initRoleData(){
        String roleData =  getDataFromFile(roleDataFileName);
        Role[] roles = gson.fromJson(roleData, Role[].class);
        DataStore.getInstance().setRoles(Arrays.asList(roles));
    }
}
