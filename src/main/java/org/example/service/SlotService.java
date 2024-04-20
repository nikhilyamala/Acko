package org.example.service;

import org.example.dao.SlotDao;
import org.example.entities.Slot;
import org.example.entities.SlotStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SlotService {

    private SlotDao slotDao;
    private String EXPECTED_DATE_FORMAT = "21-Apr-2024 16:00:00";


    public SlotService() {
        this.slotDao = SlotDao.getInstance();
    }

    public void addSlot(String adminId, String name, String startTime, String endTime){

        //String[] timeParts = startTime.split("/");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

        try {
            Date starttime = formatter.parse(startTime);
            Date endtime = formatter.parse(endTime);

            synchronized (this) {
                Slot slot = new Slot(adminId, name, starttime, endtime);
                slotDao.getSlotMap().put(slot.getId(), slot);
            }

            System.out.println("slot added successfully in " + name);

        } catch(Exception e){

            System.out.println("Invalid date format received. Please give correct format like " + EXPECTED_DATE_FORMAT);
            return;
        }

    }

    public void getAllBookedSlotsOfUser(String userId){

        HashMap<String,Slot> allSlots = slotDao.getSlotMap();

        for(Map.Entry<String,Slot> entry: allSlots.entrySet()) {

            if (entry.getValue().getSlotStatus() == SlotStatus.BOOKED && entry.getValue().getBookedUser().equalsIgnoreCase(userId)) {

                System.out.println("SlotId - " + entry.getValue().getId() + " booked by user - " + entry.getValue().getBookedUser());
            }
        }
    }

    public void bookSlot(String userId, String slotId){

        Slot slot = slotDao.getSlotMap().get(slotId);
        slot.setBookedUser(userId);
        slot.setSlotStatus(SlotStatus.BOOKED);

        System.out.println("slot booked successfully by " + userId);
    }

    public void getAllAvailableSlots(){

        HashMap<String,Slot> allSlots = slotDao.getSlotMap();


        for(Map.Entry<String,Slot> entry: allSlots.entrySet()){

            if(entry.getValue().getSlotStatus() == SlotStatus.AVAILABLE){

                System.out.println("available slot id " + entry.getValue().getId() + " in " + entry.getValue().getName() + " " +  entry.getValue().getStartTime() + " " + entry.getValue().getEndTime());
            }
        }
    }


}
