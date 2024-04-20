package org.example.entities;

import java.util.Date;
import java.util.UUID;

public class Slot {
    private String id;
    private Date startTime;
    private Date endTime;
    private String name;

    private SlotStatus slotStatus;
    private String adminId;

    private String bookedUser;

    public Slot(String adminId, String name,Date startTime, Date endTime) {
        this.id = UUID.randomUUID().toString();
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.adminId = adminId;
        this.slotStatus = SlotStatus.AVAILABLE;
    }


    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getBookedUser() {
        return bookedUser;
    }

    public void setBookedUser(String bookedUser) {
        this.bookedUser = bookedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
