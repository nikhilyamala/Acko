package org.example.service;

import org.example.dao.UserDao;
import org.example.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private UserDao userDao;

    private SlotService slotService;

    public UserService() {
        this.userDao = UserDao.getInstance();
        this.slotService = new SlotService();
    }


    public void addUser(String name){

        User user = new User(name);

        userDao.getUserMap().put(user.getId(), user);

        System.out.println("user added successfully " + name);
    }

    public void bookSlot(String userId, String slotId){

        if(!isValidUser(userId)){
            return;
        }

        slotService.bookSlot(userId,slotId);

    }


    public void getAllBookedSlots(String userId){

        if(!isValidUser(userId)){
            return;
        }

        slotService.getAllBookedSlotsOfUser(userId);
    }

    public boolean isValidUser(String userId){

        if(!userDao.getUserMap().containsKey(userId)){
            System.out.println("user is not registered ");
            return false;
        }

        return true;
    }

    public void printAllUsers(){

        HashMap<String, User> userMap = userDao.getUserMap();


        for(Map.Entry<String,User> entry: userMap.entrySet()){

            System.out.println("userId - " + entry.getKey());
        }
    }
}
