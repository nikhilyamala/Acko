package org.example.service;

import org.example.dao.AdminDao;
import org.example.entities.Admin;
import org.example.entities.User;

import java.util.HashMap;
import java.util.Map;

public class AdminService {

    private AdminDao adminDao;

    private SlotService slotService;

    public AdminService() {
        this.adminDao = AdminDao.getInstance();
        this.slotService = new SlotService();
    }


    public void addSlot(String adminId,String name,String startTime, String endTime){

        if(!isValidAdmin(adminId)){
            return;
        }
        slotService.addSlot(adminId,name,startTime,endTime);
    }


    public void addAdmin(String name){

        Admin admin = new Admin(name);
        adminDao.getAdminMap().put(admin.getId(),admin);
        System.out.println("adminId  " + admin.getId() + " added successfully");
    }
    public boolean isValidAdmin(String adminId){

        if(adminDao.getAdminMap().containsKey(adminId)){
            //System.out.println("adminId " + adminId + " exists in the system.");
            return true;
        } else {
            System.out.println("adminId " + adminId + " doesn't exist in the system.");
            return false;
        }
    }

    public void printAllAdmins(){

        HashMap<String, Admin> userMap = adminDao.getAdminMap();


        for(Map.Entry<String,Admin> entry: userMap.entrySet()){

            System.out.println("userId - " + entry.getKey());
        }
    }
}
