package br.edu.ifba.inf008.eventManager.services;

import br.edu.ifba.inf008.eventManager.model.events.Event;
import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public interface EnrollmentStrategy {
    void processAdditionalEnrollment(Participant participant, Event event);
}