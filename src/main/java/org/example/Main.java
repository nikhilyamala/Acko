package org.example;

import org.example.service.AdminService;
import org.example.service.SlotService;
import org.example.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        SlotService slotService = new SlotService();
        AdminService adminService = new AdminService();

        while(true) {
            outer:
            switch (sc.nextInt()) {

                case 0:
                    String name = sc.next();
                    userService.addUser(name);
                    break;
                case 1:
                    String n1 = sc.next();
                    adminService.addAdmin(n1);
                    break;
                case 2:
                    String adId = sc.next();
                    String slName = sc.next();
                    String st = "21-Apr-2024 16:00:00";
                    String en = "21-Apr-2024 18:00:00";
                    adminService.addSlot(adId, slName, st, en);
                    break;

                case 4:
                    String uId = sc.next();
                    String slotId = sc.next();
                    userService.bookSlot(uId, slotId);
                    break;
                case 5:

                    slotService.getAllAvailableSlots();
                    break;
                case 6:
                    userService.printAllUsers();
                    break;

                case 7:
                    adminService.printAllAdmins();
                    break;
                case 8:
                    String usId = sc.next();
                    userService.getAllBookedSlots(usId);
                    break;

                case 9:
                    break outer;
            }

        }

    }


}