package br.edu.ifba.inf008.eventManager.services.controllers;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class Controller {

    public static boolean isParticipantRegistered(Participant participant, String name, String email) {
        return participant.getEmail().equalsIgnoreCase(email) && participant.getName().equalsIgnoreCase(name); 
    }
}
