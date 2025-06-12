package br.edu.ifba.inf008.eventManager.ui;

import java.util.Scanner;

import br.edu.ifba.inf008.eventManager.model.participants.Guest;
import br.edu.ifba.inf008.eventManager.model.participants.Professor;
import br.edu.ifba.inf008.eventManager.model.participants.Student;
import br.edu.ifba.inf008.eventManager.services.management.EventManager;

public class InteractiveRegisterParticipantMenu {

    public static void displayMenu(Scanner scanner, EventManager eventManager) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Participant Registration Menu ---");
            System.out.println("1. Register New Student");
            System.out.println("2. Register New Professor");
            System.out.println("3. Register New Guest");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> registerStudent(scanner, eventManager);
                case 2 -> registerProfessor(scanner, eventManager);
                case 3 -> registerGuest(scanner, eventManager);
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void registerStudent(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Student --");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Student ID: ");
        String regId = scanner.nextLine();
        System.out.print("Enrolled Course Name: ");
        String courseName = scanner.nextLine();
        Student student = new Student(name, email, regId, courseName);
        eventManager.addGlobalParticipant(student);
    }

    private static void registerProfessor(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Professor --");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Department: ");
        String dept = scanner.nextLine();
        System.out.print("SIAPE ID: ");
        String siape = scanner.nextLine();
        Professor professor = new Professor(name, email, dept, siape);
        eventManager.addGlobalParticipant(professor);
    }

    private static void registerGuest(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Guest --");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Affiliated Organization [default: N/A]: ");
        String org = scanner.nextLine();
        if (org.isEmpty()) org = "N/A";
        System.out.print("National ID (e.g., CPF): ");
        String nationalId = scanner.nextLine();
        Guest guest = new Guest(name, email, org, nationalId);
        eventManager.addGlobalParticipant(guest);
    }
}
