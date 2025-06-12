package br.edu.ifba.inf008.eventManager.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.edu.ifba.inf008.eventManager.model.events.AcademicFair;
import br.edu.ifba.inf008.eventManager.model.events.Course;
import br.edu.ifba.inf008.eventManager.model.events.Lecture;
import br.edu.ifba.inf008.eventManager.model.events.Workshop;
import br.edu.ifba.inf008.eventManager.services.OnSiteEnrollmentStrategy;
import br.edu.ifba.inf008.eventManager.services.OnlineEnrollmentStrategy;
import br.edu.ifba.inf008.eventManager.services.management.EventManager;
import br.edu.ifba.inf008.eventManager.utils.FormatterUtil;

public class InteractiveRegisterEventMenu {

    public static void displayMenu(Scanner scanner, EventManager eventManager) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Registration Menu ---");
            System.out.println("1. Register Lecture");
            System.out.println("2. Register Workshop");
            System.out.println("3. Register Course");
            System.out.println("4. Register Academic Fair");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> registerLecture(scanner, eventManager);
                case 2 -> registerWorkshop(scanner, eventManager);
                case 3 -> registerCourse(scanner, eventManager);
                case 4 -> registerAcademicFair(scanner, eventManager);
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerLecture(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Lecture --");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Date (DD-MM-YYYY): ");
        String dateStr = scanner.nextLine();
        LocalDate date = FormatterUtil.parseDate(dateStr);
        if (date == null) { System.out.println("Lecture registration cancelled due to invalid date."); return; }
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Maximum Capacity: ");
        int capacity = scanner.nextInt(); scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Speaker's Name: ");
        String speakerName = scanner.nextLine();
        System.out.print("Enrollment Type (online/on-site) [default: on-site]: ");
        String enrollmentTypeStr = scanner.nextLine();
        if (enrollmentTypeStr.isEmpty()) enrollmentTypeStr = "on-site";

        Lecture lecture = new Lecture(title, date, location, capacity, description, speakerName);
        if ("online".equalsIgnoreCase(enrollmentTypeStr)) {
            lecture.setEnrollmentStrategy(new OnlineEnrollmentStrategy());
        } else {
            lecture.setEnrollmentStrategy(new OnSiteEnrollmentStrategy());
        }
        eventManager.registerEvent(lecture);
    }

    private static void registerWorkshop(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Workshop --");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Date (DD-MM-YYYY): ");
        String dateStr = scanner.nextLine();
        LocalDate date = FormatterUtil.parseDate(dateStr);
        if (date == null) { System.out.println("Workshop registration cancelled due to invalid date."); return; }
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Maximum Capacity: ");
        int capacity = scanner.nextInt(); scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Instructor's Name: ");
        String instructorName = scanner.nextLine();
        System.out.print("Enrollment Type (online/on-site) [default: on-site]: ");
        String enrollmentTypeStr = scanner.nextLine();
        if (enrollmentTypeStr.isEmpty()) enrollmentTypeStr = "on-site";

        Workshop workshop = new Workshop(title, date, location, capacity, description, instructorName);
        if ("online".equalsIgnoreCase(enrollmentTypeStr)) {
            workshop.setEnrollmentStrategy(new OnlineEnrollmentStrategy());
        } else {
            workshop.setEnrollmentStrategy(new OnSiteEnrollmentStrategy());
        }
        eventManager.registerEvent(workshop);
    }

    private static void registerCourse(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Course --");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Date (DD-MM-YYYY): ");
        String dateStr = scanner.nextLine();
        LocalDate date = FormatterUtil.parseDate(dateStr);
        if (date == null) { System.out.println("Course registration cancelled due to invalid date."); return; }
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Maximum Capacity: ");
        int capacity = scanner.nextInt(); scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Workload Hours: ");
        int workload = scanner.nextInt(); scanner.nextLine();
        
        System.out.print("Enrollment Type (online/on-site) [default: on-site]: ");
        String enrollmentTypeStr = scanner.nextLine();
        if (enrollmentTypeStr.isEmpty()) enrollmentTypeStr = "on-site";

        Course course = new Course(title, date, location, capacity, description, workload);
        if ("online".equalsIgnoreCase(enrollmentTypeStr)) {
            course.setEnrollmentStrategy(new OnlineEnrollmentStrategy());
        } else {
            course.setEnrollmentStrategy(new OnSiteEnrollmentStrategy());
        }
        eventManager.registerEvent(course);
    }

    private static void registerAcademicFair(Scanner scanner, EventManager eventManager) {
        System.out.println("\n-- Register New Academic Fair --");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Date (DD-MM-YYYY): ");
        String dateStr = scanner.nextLine();
        LocalDate date = FormatterUtil.parseDate(dateStr);
        if (date == null) { System.out.println("Fair registration cancelled due to invalid date."); return; }
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Maximum Capacity: ");
        int capacity = scanner.nextInt(); scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Main Theme: ");
        String theme = scanner.nextLine();
        System.out.print("Organizers (comma-separated): ");
        String organizersStr = scanner.nextLine();
        List<String> organizers = organizersStr.isEmpty()? Collections.emptyList() : new ArrayList<>(Arrays.asList(organizersStr.split("\\s*,\\s*")));
        
        System.out.print("Enrollment Type (online/on-site) [default: on-site]: ");
        String enrollmentTypeStr = scanner.nextLine();
        if (enrollmentTypeStr.isEmpty()) enrollmentTypeStr = "on-site";

        AcademicFair fair = new AcademicFair(title, date, location, capacity, description, theme, organizers);
         if ("online".equalsIgnoreCase(enrollmentTypeStr)) {
            fair.setEnrollmentStrategy(new OnlineEnrollmentStrategy());
        } else {
            fair.setEnrollmentStrategy(new OnSiteEnrollmentStrategy());
        }
        eventManager.registerEvent(fair);
    }
}
