package com.deputy.assignment;

import com.deputy.assignment.model.User;

import java.util.List;

public class AppMain {

    private UserController userController;

    public AppMain() {
        ApplicationInitializer applicationInitializer = new ApplicationInitializer("userdata.json","roledata.json");
        applicationInitializer.init();
        userController = applicationInitializer.getUserController();
    }

    public static void main(String a[]){
        AppMain application = new AppMain();
        application.findSubordinates(3);
        application.findSubordinates(1);
    }

    private  void findSubordinates(int userId) {
        System.out.println("\nFinding Subordinates of user with ID : " + userId);
        List<User> users = userController.getSubOrdinates(userId);
        if(users!= null){
            users.forEach(System.out::println);
        }
    }
}
