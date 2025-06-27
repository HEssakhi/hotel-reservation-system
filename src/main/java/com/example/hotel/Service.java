package com.example.hotel;

import java.util.*;

public class Service {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) return;
        }
        rooms.add(0, new Room(roomNumber, roomType, roomPricePerNight)); // Add latest to top
    }

    public void setUser(int userId, int balance) {
        for (User user : users) {
            if (user.id == userId) return;
        }
        users.add(0, new User(userId, balance));
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        try {
            if (!checkIn.before(checkOut)) {
                throw new IllegalArgumentException("Invalid date range.");
            }

            Room room = null;
            for (Room r : rooms) {
                if (r.roomNumber == roomNumber) {
                    room = r;
                    break;
                }
            }
            if (room == null) throw new IllegalArgumentException("Room not found.");

            User user = null;
            for (User u : users) {
                if (u.id == userId) {
                    user = u;
                    break;
                }
            }
            if (user == null) throw new IllegalArgumentException("User not found.");

            for (Booking booking : bookings) {
                if (booking.roomNumber == roomNumber &&
                        !(checkOut.before(booking.checkIn) || checkIn.after(booking.checkOut))) {
                    throw new IllegalStateException("Room not available for given period.");
                }
            }

            long nights = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
            int totalPrice = (int)nights * room.pricePerNight;

            if (user.balance < totalPrice) {
                throw new IllegalStateException("Insufficient balance.");
            }

            user.balance -= totalPrice;
            bookings.add(0, new Booking(user.id, room.roomNumber, checkIn, checkOut, room, user));
        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    public void printAll() {
        System.out.println("All Rooms");
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println("Bookings Details");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void printAllUsers() {
        System.out.println("All Users");
        for (User user : users) {
            System.out.println(user);
        }
    }
}

