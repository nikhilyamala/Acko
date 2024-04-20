package org.example.dao;

import org.example.entities.User;

import java.util.HashMap;

public class UserDao {

    private static HashMap<String, User> userMap;

    private static UserDao instance;


    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public static UserDao getInstance(){

        if(instance == null){
            userMap = new HashMap<>();
            instance = new UserDao();
        }
        return instance;
    }
}
