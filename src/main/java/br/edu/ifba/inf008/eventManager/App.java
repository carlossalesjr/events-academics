package br.edu.ifba.inf008.eventManager;

import java.util.Scanner;

import br.edu.ifba.inf008.eventManager.services.management.EventManager;
import br.edu.ifba.inf008.eventManager.ui.InteractiveCertificateMenu;
import br.edu.ifba.inf008.eventManager.ui.InteractiveEventMenu;
import br.edu.ifba.inf008.eventManager.ui.InteractiveParticipantsMenu;
import br.edu.ifba.inf008.eventManager.ui.InteractiveReportsMenu;

public class App {

    private static EventManager eventManagerInstance = new EventManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Academic Event Manager!");
        mainMenuLoop();
        scanner.close();
        System.out.println("Exiting the system...");
    }

    private static void mainMenuLoop() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Events");
            System.out.println("2. Manage Participants");
            System.out.println("3. Generate Certificates");
            System.out.println("4. Generate Reports");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    InteractiveEventMenu.displayMenu(scanner, eventManagerInstance);
                    break;
                case 2:
                    InteractiveParticipantsMenu.displayMenu(scanner, eventManagerInstance);
                    break;
                case 3:
                    InteractiveCertificateMenu.displayMenu(scanner, eventManagerInstance);
                    break;
                case 4:
                    InteractiveReportsMenu.displayMenu(scanner, eventManagerInstance);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
