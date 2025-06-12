package br.edu.ifba.inf008.eventManager.services;

import br.edu.ifba.inf008.eventManager.model.events.Event;
import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class OnlineEnrollmentStrategy implements EnrollmentStrategy {
    @Override
    public void processAdditionalEnrollment(Participant participant, Event event) {
        System.out.println("Processing ONLINE enrollment for " +
                           participant.getName() + " in event " + event.getTitle() + ".");
        System.out.println(" -> Access link and materials will be sent to email: " +
                           participant.getEmail());
    }
}