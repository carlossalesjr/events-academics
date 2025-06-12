package br.edu.ifba.inf008.eventManager.ui;

import java.util.Scanner;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;
import br.edu.ifba.inf008.eventManager.services.management.EventManager;

public class InteractiveParticipantsMenu {

    public static void displayMenu(Scanner scanner, EventManager eventManager) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Participant Management Menu ---");
            System.out.println("1. Register New Participant");
            System.out.println("2. Find Participant by Email");
            // Add more options like list all participants if needed
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> InteractiveRegisterParticipantMenu.displayMenu(scanner, eventManager); // Delegate to specific registration
                case 2 -> findParticipantByEmail(scanner, eventManager);
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void findParticipantByEmail(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Find Participant by Email --");
        System.out.print("Enter participant's email: ");
        String email = scanner.nextLine();
        Participant participant = eventManager.findParticipantByEmail(email);
        if (participant!= null) {
            System.out.println("Participant found:");
            System.out.println(participant);
        } else {
            System.out.println("Participant with email '" + email + "' not found.");
        }
    }
}
