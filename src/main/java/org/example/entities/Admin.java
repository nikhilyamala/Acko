package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Admin {
    private String id;
    private String name;
    //private List<Slot> slots;

    public Admin(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Slot> getSlots() {
//        return slots;
//    }
//
//    public void setSlots(List<Slot> slots) {
//        this.slots = slots;
//    }
}
