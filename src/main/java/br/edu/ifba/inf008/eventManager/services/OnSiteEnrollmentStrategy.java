package br.edu.ifba.inf008.eventManager.services;

import br.edu.ifba.inf008.eventManager.model.events.Event;
import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class OnSiteEnrollmentStrategy implements EnrollmentStrategy {
    @Override
    public void processAdditionalEnrollment(Participant participant, Event event) {
        System.out.println("Processing ON-SITE enrollment for " +
                           participant.getName() + " in event " + event.getTitle() + ".");
        System.out.println(" -> Confirm your attendance at the location: " + event.getLocation() +
                           " 30 minutes in advance.");
    }
}