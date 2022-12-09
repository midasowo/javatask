package org.example;

public class HotelRoom {

    int roomNumber;
    int numberPfBeds;
    boolean available;

    public HotelRoom(int roomNumber, int numberPfBeds, boolean available) {
        this.roomNumber = roomNumber;
        this.numberPfBeds = numberPfBeds;
        this.available = available;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "roomNumber=" + roomNumber +
                ", numberPfBeds=" + numberPfBeds +
                ", available=" + available +
                '}';
    }
}
