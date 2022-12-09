package org.example;

public class HotelRoom {

    private int roomNumber;
    private int numberPfBeds;
    private boolean available;

    public HotelRoom(int roomNumber, int numberPfBeds, boolean available) {
        this.roomNumber = roomNumber;
        this.numberPfBeds = numberPfBeds;
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberPfBeds() {
        return numberPfBeds;
    }

    public void setNumberPfBeds(int numberPfBeds) {
        this.numberPfBeds = numberPfBeds;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
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
