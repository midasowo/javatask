package org.example;

import java.util.Scanner;

public class Main {
    static HotelRoom room1 = new HotelRoom(1, 1, true);
    static HotelRoom room2 = new HotelRoom(2, 1, true);
    static HotelRoom room3 = new HotelRoom(3, 1, true);

    static HotelRoom[] fullRooms = new HotelRoom[3];
    static HotelRoom[] emptyRooms = new HotelRoom[]{room1, room2, room3};

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
        System.out.println("Podaj numer pokoju");
        for (int i = 0; i < emptyRooms.length; i++) {
            System.out.println("(" + (i + 1) + ") " + emptyRooms[i]);
        }
        int choice = input.nextInt();
        if (choice < emptyRooms.length) {
            fullRooms[choice - 1] = emptyRooms[choice - 1];
            emptyRooms[choice - 1] = null;
        } else {
            System.out.println("Błędna wartość");
        }
    }

    static void showEmptyRooms() {
        System.out.println("Wolne pokoje");
        for (HotelRoom emptyRoom : emptyRooms) {
            System.out.println(emptyRoom);
        }
    }

    static void showFullRooms() {
        System.out.println("Wszystkie pokoje");
        for (HotelRoom fullRoom : fullRooms) {
            System.out.println(fullRoom);
        }
    }

    static void showAllRooms() {
        showEmptyRooms();
        showFullRooms();
    }

    static void releaseRoom() {
        System.out.println("Podaj numer pokoju");
        for (int i = 0; i < fullRooms.length; i++) {
            System.out.println("(" + (i + 1) + ") " + emptyRooms[i]);
        }
        int choice = input.nextInt();
        if (choice < emptyRooms.length) {
            emptyRooms[choice - 1] = fullRooms[choice - 1];
            fullRooms[choice - 1] = null;
        } else {
            System.out.println("Błędna wartość");
        }
    }

}
