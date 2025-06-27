package com.example.hotel;

public class Room {
    int roomNumber;
    RoomType type;
    int pricePerNight;

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{id=" + roomNumber + ", type=" + type + ", price=" + pricePerNight + "}";
    }
}

