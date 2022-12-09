package org.example;

import java.util.Scanner;

public class Main {
    static HotelRoom room1 = new HotelRoom(1, 1, true);
    static HotelRoom room2 = new HotelRoom(2, 1, true);
    static HotelRoom room3 = new HotelRoom(3, 1, true);

    static HotelRoom[] rooms = new HotelRoom[]{room1, room2, room3};

    static boolean mainMenu = true;
    static boolean subMenu = true;


    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (mainMenu) {
            while (subMenu) {
                System.out.println("Wybierz jedną z opcji");
                System.out.println("1. Zarezerwuj pokój");
                System.out.println("2. Wyświetl puste pokoje");
                System.out.println("3. Wyświetl wszystkie pokoje");
                System.out.println("4. Zwolnij pokój");

                int selection = input.nextInt();
                switch (selection) {
                    case 1:
                        bookRooms();
                        break;
                    case 2:
                        showEmptyRooms();
                        break;
                    case 3:
                        showAllRooms();
                        break;
                    case 4:
                        releaseRoom();
                        break;
                    case 5:
                        System.out.println("Invalid selection");
                        break;
                }
                System.out.println("Czy chcesz wybrać inną opcję?\n1) Tak\n 2) Nie");
                subMenu = input.nextInt() == 1;
            }
            subMenu = true;

            System.out.println("Czy chcesz kontynuować?\n1) Tak\n 2) Nie");
            if (input.nextInt() == 1) {
                mainMenu = true;
            } else {
                System.out.println();
                System.exit(0);
            }
        }
    }

    static void bookRooms() {
        if (showEmptyRooms() != 0) {
            System.out.println("Podaj numer pokoju");
            int choice = input.nextInt();
            rooms[choice].setAvailable(false);
            System.out.println("Zarezerwowano pokój: " + rooms[choice]);
        } else System.out.println("Nie ma wolnych pokoi");
    }

    static int showEmptyRooms() {
        int count = 0;
        System.out.println("Wolne pokoje: ");
        for (HotelRoom room : rooms) {
            if (room.isAvailable()) {
                count++;
                System.out.println("(" + room.getRoomNumber() + ")" + room);
            }
        }
        if (count == 0) System.out.println("Brak wolnych pokoi");
        return count;
    }

    static int showFullRooms() {
        int count = 0;
        System.out.println("Zajęte pokoje");
        for (HotelRoom room : rooms) {
            if (!room.isAvailable()) {
                count++;
                System.out.println("(" + room.getRoomNumber() + ")" + room);
            }
        }
        if (count == 0) System.out.println("Wszystkie pokoje wolne");
        return count;
    }

    static void showAllRooms() {
        showEmptyRooms();
        showFullRooms();
    }

    static void releaseRoom() {
        if (showFullRooms() != 0) {
            System.out.println("Podaj numer pokoju");
            int choice = input.nextInt();
            if (rooms[choice].getRoomNumber() == choice) {
                rooms[choice].setAvailable(true);
                System.out.println("Zwolniono pokój: " + rooms[choice]);
            }
            else System.out.println("Błędna operacja");
        } else System.out.println("Nie ma wolnych pokoi");
    }

}
