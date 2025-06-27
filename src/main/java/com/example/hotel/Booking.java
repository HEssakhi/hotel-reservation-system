package com.example.hotel;

import java.util.Date;

public class Booking {
    int userId;
    int roomNumber;
    Date checkIn;
    Date checkOut;
    Room roomSnapshot;
    User userSnapshot;

    public Booking(int userId, int roomNumber, Date checkIn, Date checkOut, Room room, User user) {
        this.userId = userId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomSnapshot = new Room(room.roomNumber, room.type, room.pricePerNight);
        this.userSnapshot = new User(user.id, user.balance);
    }

    @Override
    public String toString() {
        return "Booking{\n " + userSnapshot + "\n " + roomSnapshot +
                "\n checkIn=" + checkIn + "\n checkOut=" + checkOut + "\n}";
    }
}
