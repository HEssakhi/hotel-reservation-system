package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.example.hotel.RoomType;
import com.example.hotel.Service;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception{
        Service service = new Service();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Create 3 rooms
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.SUITE, 3000);
        //Create 2 users
        service.setUser(1, 5000);
        service.setUser(2, 10000);

        //Booking tests

        service.bookRoom(1, 2, sdf.parse("30/06/2026"), sdf.parse("07/07/2026"));

        service.bookRoom(1, 2, sdf.parse("07/07/2026"), sdf.parse("30/06/2026"));

        service.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));

        service.bookRoom(2, 1, sdf.parse("07/07/2026"), sdf.parse("09/07/2026"));

        service.bookRoom(2, 3, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));

        service.setRoom(1, RoomType.SUITE, 10000);


        service.printAll();
        service.printAllUsers();
    }
}