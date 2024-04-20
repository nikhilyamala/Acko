package org.example.dao;

import org.example.entities.Slot;

import java.util.HashMap;

public class SlotDao {

    private static HashMap<String, Slot> slotMap;

    private static SlotDao instance;


    public HashMap<String, Slot> getSlotMap() {
        return slotMap;
    }

    public void setUserMap(HashMap<String, Slot> userMap) {
        this.slotMap = userMap;
    }

    public static SlotDao getInstance(){

        if(instance == null){
            slotMap = new HashMap<>();
            instance = new SlotDao();
        }
        return instance;
    }
}
