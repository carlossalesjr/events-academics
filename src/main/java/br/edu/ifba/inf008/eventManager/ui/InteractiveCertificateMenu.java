package br.edu.ifba.inf008.eventManager.ui;

import java.util.Scanner;

import br.edu.ifba.inf008.eventManager.services.management.EventManager;

public class InteractiveCertificateMenu {

    public static void displayMenu(Scanner scanner, EventManager eventManager) {
        // This menu can be simpler as it has one primary function
        System.out.println("\n--- Generate Certificate ---");
        System.out.print("Enter participant's email: ");
        String participantEmail = scanner.nextLine();
        System.out.print("Enter event title: ");
        String eventTitle = scanner.nextLine();
        
if (participantEmail.isEmpty() || eventTitle.isEmpty()) {
    System.out.println("Participant email and event title cannot be empty. Certificate generation cancelled.");
    return;
}
        eventManager.generateCertificate(eventTitle, participantEmail);
    }
}
