package com.deputy.assignment.data.provider;

import com.deputy.assignment.model.Role;
import com.deputy.assignment.model.User;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    public static List<User> loadUserData(){
        String userData = " [\n" +
                " {\n" +
                " \"Id\": 1,\n" +
                " \"Name\": \"Adam Admin\",\n" +
                " \"Role\": 1\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 2,\n" +
                " \"Name\": \"Emily Employee\",\n" +
                " \"Role\": 4\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 3,\n" +
                " \"Name\": \"Sam Supervisor\",\n" +
                " \"Role\": 3\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 4,\n" +
                " \"Name\": \"Mary Manager\",\n" +
                " \"Role\": 2\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 5,\n" +
                " \"Name\": \"Steve Trainer\",\n" +
                " \"Role\": 5\n" +
                " }\n" +
                "]\n";
        Gson gson = new Gson();
        User[] users = gson.fromJson(userData, User[].class);
        return Arrays.asList(users);
    }


    public static List<Role> loadRoleData(){
        String data =   " [\n" +
                " {\n" +
                " \"Id\": 1,\n" +
                " \"Name\": \"System Administrator\",\n" +
                " \"Parent\": 0\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 2,\n" +
                " \"Name\": \"Location Manager\",\n" +
                " \"Parent\": 1\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 3,\n" +
                " \"Name\": \"Supervisor\",\n" +
                " \"Parent\": 2\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 4,\n" +
                " \"Name\": \"Employee\",\n" +
                " \"Parent\": 3\n" +
                " },\n" +
                " {\n" +
                " \"Id\": 5,\n" +
                " \"Name\": \"Trainer\",\n" +
                " \"Parent\": 3\n" +
                " }\n" +
                "]\n";

        Gson gson = new Gson();
        Role[] roles = gson.fromJson(data, Role[].class);
        return Arrays.asList(roles);
    }
}
