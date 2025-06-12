package br.edu.ifba.inf008.eventManager.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.edu.ifba.inf008.eventManager.model.events.Event;
import br.edu.ifba.inf008.eventManager.services.management.EventManager;
import br.edu.ifba.inf008.eventManager.utils.FormatterUtil;

public class InteractiveEventMenu {

    public static void displayMenu(Scanner scanner, EventManager eventManager) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Event Management Menu ---");
            System.out.println("1. Register New Event");
            System.out.println("2. List All Events");
            System.out.println("3. Find Events by Type");
            System.out.println("4. Find Events by Date");
            System.out.println("5. Enroll Participant in Event");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> InteractiveRegisterEventMenu.displayMenu(scanner, eventManager); // Delegate to specific registration
                case 2 -> listAllEvents(eventManager);
                case 3 -> findEventsByType(scanner, eventManager);
                case 4 -> findEventsByDate(scanner, eventManager);
                case 5 -> enrollParticipantInEvent(scanner, eventManager);
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void listAllEvents(EventManager eventManager) {
        List<Event> events = eventManager.listAllEvents();
        if (events.isEmpty()) {
            System.out.println("No events registered.");
            return;
        }
        System.out.println("\n--- List of All Events ---");
        events.forEach(System.out::println);
        System.out.println("--------------------------");
    }

    private static void findEventsByType(Scanner scanner, EventManager eventManager) {
        System.out.print("Enter event type (lecture, workshop, course, fair): ");
        String type = scanner.nextLine();
        List<Event> events = eventManager.listEventsByType(type);
        if (events.isEmpty()) {
            System.out.println("No events found for type: " + type);
            return;
        }
        System.out.println("\n--- Events of Type: " + type.toUpperCase() + " ---");
        events.forEach(System.out::println);
        System.out.println("-----------------------------");
    }

    private static void findEventsByDate(Scanner scanner, EventManager eventManager) {
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate date = FormatterUtil.parseDate(dateStr);
        if (date == null) { System.out.println("Search cancelled due to invalid date."); return; }

        List<Event> events = eventManager.listEventsByDate(date);
        if (events.isEmpty()) {
            System.out.println("No events found for date: " + FormatterUtil.formatDate(date));
            return;
        }
        System.out.println("\n--- Events on Date: " + FormatterUtil.formatDate(date) + " ---");
        events.forEach(System.out::println);
        System.out.println("--------------------------------");
    }

    private static void enrollParticipantInEvent(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Enroll Participant in Event --");
        System.out.print("Enter participant's email: ");
        String participantEmail = scanner.nextLine();
        System.out.print("Enter event title: ");
        String eventTitle = scanner.nextLine();
        eventManager.enrollParticipantInEvent(participantEmail, eventTitle);
    }
}
