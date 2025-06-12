package br.edu.ifba.inf008.eventManager.services.management;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.edu.ifba.inf008.eventManager.model.events.Course;
import br.edu.ifba.inf008.eventManager.model.events.Event;
import br.edu.ifba.inf008.eventManager.model.events.Lecture;
import br.edu.ifba.inf008.eventManager.model.events.Workshop;
import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class EventManager {
    private List<Event> events;
    private List<Participant> globalParticipants;

    public EventManager() {
        this.events = new ArrayList<>();
        this.globalParticipants = new ArrayList<>();
    }

    public void registerEvent(Event event) {
        if (events.stream().anyMatch(e -> e.getTitle().equalsIgnoreCase(event.getTitle()) && e.getDate().equals(event.getDate()))) {
            System.out.println("Error: Event with the same title and date already registered.");
            return;
        }
        this.events.add(event);
        System.out.println("Event '" + event.getTitle() + "' registered successfully.");
    }

    public void addGlobalParticipant(Participant participant) {
        if (globalParticipants.stream().noneMatch(p -> p.getEmail().equalsIgnoreCase(participant.getEmail()))) {
            this.globalParticipants.add(participant);
            System.out.println("Participant '" + participant.getName() + "' added to the system.");
        } else {
            System.out.println("Participant with email '" + participant.getEmail() + "' already exists in the system.");
        }
    }
    
    public Participant findParticipantByEmail(String email) {
        return globalParticipants.stream()
             .filter(p -> p.getEmail().equalsIgnoreCase(email))
             .findFirst()
             .orElse(null);
    }

    public Event findEventByTitle(String title) {
        return events.stream()
             .filter(e -> e.getTitle().equalsIgnoreCase(title))
             .findFirst()
             .orElse(null);
    }

    public void enrollParticipantInEvent(String participantEmail, String eventTitle) {
        Participant participant = findParticipantByEmail(participantEmail);
        Event event = findEventByTitle(eventTitle);

        if (participant == null) {
            System.out.println("Error: Participant with email '" + participantEmail + "' not found.");
            return;
        }
        if (event == null) {
            System.out.println("Error: Event with title '" + eventTitle + "' not found.");
            return;
        }
        event.enrollParticipant(participant);
    }

    public List<Event> listAllEvents() {
        return new ArrayList<>(this.events);
    }

    public List<Event> listEventsByType(String desiredType) {
        return this.events.stream()
         .filter(event -> {
                if (desiredType.equalsIgnoreCase("lecture") && event instanceof Lecture) return true;
                if (desiredType.equalsIgnoreCase("workshop") && event instanceof Workshop) return true;
                if (desiredType.equalsIgnoreCase("course") && event instanceof Course) return true;
                return false;
            })
         .collect(Collectors.toList());
    }

    public List<Event> listEventsByDate(LocalDate desiredDate) {
        return this.events.stream()
         .filter(event -> event.getDate().equals(desiredDate))
         .collect(Collectors.toList());
    }

    public void generateCertificate(String eventTitle, String participantEmail) {
        Event event = findEventByTitle(eventTitle);
        Participant participant = findParticipantByEmail(participantEmail);

        if (event == null) {
            System.err.println("Error: Event '" + eventTitle + "' not found.");
            return;
        }
        if (participant == null) {
            System.err.println("Error: Participant with email '" + participantEmail + "' not found.");
            return;
        }

        if (!event.getEnrolledParticipants().contains(participant)) {
            System.err.println("Error: " + participant.getName() + " is not enrolled in event " + event.getTitle() + ".");
            return;
        }

        String fileName = "certificate_" +
                             participant.getName().replaceAll("\\s+", "_") + "_" +
                             event.getTitle().replaceAll("\\s+", "_") + ".txt";
        fileName = fileName.toLowerCase();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = event.getDate().format(formatter);

        StringBuilder certificateContent = new StringBuilder();
        certificateContent.append("----------------------------------------\n");
        certificateContent.append("               CERTIFICATE              \n");
        certificateContent.append("----------------------------------------\n\n");
        certificateContent.append(String.format("This is to certify that %s (%s - ID: %s)\n",
                                                 participant.getName().toUpperCase(),
                                                 participant.getParticipantType(),
                                                 participant.getPrimaryIdentification()));
        certificateContent.append(String.format("participated in the event '%s',\n", event.getTitle()));
        certificateContent.append(String.format("of type '%s',\n", event.getDetailedEventType()));
        certificateContent.append(String.format("held on %s, at '%s'.\n\n", formattedDate, event.getLocation()));
        certificateContent.append(String.format("Event Description: %s\n", event.getDescription()));

        if (event instanceof Lecture) {
            certificateContent.append(String.format("Speaker: %s\n", ((Lecture) event).getSpeaker()));
        } else if (event instanceof Course) {
            certificateContent.append(String.format("Workload: %d hours\n", ((Course) event).getWorkloadHours()));
        } else if (event instanceof Workshop) {
            certificateContent.append(String.format("Instructor: %s\n", ((Workshop) event).getInstructor()));
        }

        certificateContent.append("\n----------------------------------------\n");

        try {
            Path path = Paths.get(fileName);
            Files.writeString(path, certificateContent.toString());
            System.out.println("Certificate generated successfully: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error generating certificate for " + participant.getName() + ": " + e.getMessage());
        }
    }
    
    public Map<String, Integer> getEventCountByType() {
        Map<String, Integer> count = new HashMap<>();
        for (Event event : events) {
            String type = event.getDetailedEventType();
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        return count;
    }

    public Map<String, Integer> getParticipantCountByEvent() {
        Map<String, Integer> count = new HashMap<>();
        for (Event event : events) {
            count.put(event.getTitle(), event.getEnrolledParticipants().size());
        }
        return count;
    }
}