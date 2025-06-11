package br.edu.ifba.inf008.eventManager.ui;

import com.sun.tools.javac.Main;

public class ParticipantsMenu {
    public void show() {
        System.out.println("---- Participants Menu ----");
        System.out.println("1 -> Register");
        System.out.println("2 -> Edit");
        System.out.println("3 -> Delete");
        System.out.println("4 -> Back to Main Menu");

        int choice = getUserChoice(); 

        switch (choice) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                MainMenu.show();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void listParticipants() {
        System.out.println("Listing all participants...");
    }

    private void addParticipant() {
        System.out.println("Adding a new participant...");
    }

    private void removeParticipant() {
        System.out.println("Removing a participant...");
    }

    private static int getUserChoice() {
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return -1; 
    }

}
