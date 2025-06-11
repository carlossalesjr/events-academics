package br.edu.ifba.inf008.eventManager.ui;

public class MainMenu {
    private static boolean running = true;

    public static void show() {
        // Display the main menu options
        System.out.println("---- Welcome to the Event Manager! ----");
        System.out.println("1 -> Participants");
        System.out.println("2 -> Events");
        System.out.println("3 -> Reports");
        System.out.println("4 -> Certificates");
        System.out.println("5 -> Exit");
        System.out.println("What do you wanna see now?");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                
            case 2:
                
            case 3:
            
            case 4:
                
            case 5:
                System.out.println("Exiting the application. Goodbye!");
                running = false;
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
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

    public static boolean isRunning() {
        return running;
    }

}
