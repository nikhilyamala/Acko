package org.example.dao;

import org.example.entities.Admin;

import java.util.HashMap;

public class AdminDao {
    private static HashMap<String, Admin> adminMap;

    private static AdminDao instance;


    public HashMap<String, Admin> getAdminMap() {
        return adminMap;
    }

    public void setAdminMap(HashMap<String, Admin> adminMap) {
        this.adminMap = adminMap;
    }

    public static void setInstance(AdminDao instance) {
        AdminDao.instance = instance;
    }

    public static AdminDao getInstance(){

        if(instance == null){
            adminMap = new HashMap<>();
            instance = new AdminDao();
        }
        return instance;
    }
}
