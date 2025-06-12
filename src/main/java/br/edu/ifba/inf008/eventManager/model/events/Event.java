package br.edu.ifba.inf008.eventManager.model.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;
import br.edu.ifba.inf008.eventManager.services.EnrollmentStrategy;

public abstract class Event {
    private String title;
    private LocalDate date;
    private String location;
    private int maxCapacity;
    private String description;
    private List<Participant> enrolledParticipants;
    private EnrollmentStrategy enrollmentStrategy;

    public Event(String title, LocalDate date, String location, int maxCapacity, String description) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.description = description;
        this.enrolledParticipants = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Participant> getEnrolledParticipants() {
        return enrolledParticipants;
    }

    public int getAvailableSlots() {
        return maxCapacity - enrolledParticipants.size();
    }

    public void setEnrollmentStrategy(EnrollmentStrategy enrollmentStrategy) {
        this.enrollmentStrategy = enrollmentStrategy;
    }

    public EnrollmentStrategy getEnrollmentStrategy() {
        return enrollmentStrategy;
    }

    public void enrollParticipant(Participant participant) {
        if (enrolledParticipants.size() >= maxCapacity) {
            System.out.println("Event '" + title + "' is full. Could not enroll " + participant.getName() + ".");
            return;
        }
        if (enrolledParticipants.contains(participant)) {
            System.out.println(participant.getName() + " is already enrolled in this event.");
            return;
        }
        enrolledParticipants.add(participant);
        System.out.println(participant.getName() + " pre-enrolled successfully in event '" + title + "'.");

        if (this.enrollmentStrategy!= null) {
            this.enrollmentStrategy.processAdditionalEnrollment(participant, this);
        } else {
            System.out.println(" -> Standard enrollment completed.");
        }
    }

    public abstract String getDetailedEventType();

    @Override
    public String toString() {
        return "Event: " + title + "\n" +
               "  Type: " + getDetailedEventType() + "\n" +
               "  Date: " + date + "\n" +
               "  Location: " + location + "\n" +
               "  Capacity: " + maxCapacity + "\n" +
               "  Enrolled: " + enrolledParticipants.size() + "\n" +
               "  Available Slots: " + getAvailableSlots() + "\n" +
               "  Description: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }
}