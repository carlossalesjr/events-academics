package br.edu.ifba.inf008.eventManager.services.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class ParticipantManager {
    private List<Participant> participants;

    public ParticipantManager() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        if (participants.stream().noneMatch(p -> p.getEmail().equalsIgnoreCase(participant.getEmail()))) {
            this.participants.add(participant);
            System.out.println("Participant " + participant.getName() + " registered in ParticipantManager's local system.");
        } else {
            System.out.println("Participant with email " + participant.getEmail() + " already exists in ParticipantManager's local system.");
        }
    }

    public Optional<Participant> findParticipantByEmail(String email) {
        return participants.stream()
                        .filter(p -> p.getEmail().equalsIgnoreCase(email))
                        .findFirst();
    }

    public List<Participant> getAllParticipants() {
        return new ArrayList<>(participants);
    }
}