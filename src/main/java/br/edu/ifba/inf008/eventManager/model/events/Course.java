package br.edu.ifba.inf008.eventManager.model.events;

import java.time.LocalDate;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;
import br.edu.ifba.inf008.eventManager.model.participants.Student;

public class Course extends Event {
    private int workloadHours;

    public Course(String title, LocalDate date, String location, int maxCapacity, String description, int workloadHours) {
        super(title, date, location, maxCapacity, description);
        this.workloadHours = workloadHours;
    }

    public int getWorkloadHours() {
        return workloadHours;
    }

    public void setWorkloadHours(int workloadHours) {
        this.workloadHours = workloadHours;
    }

    @Override
    public String getDetailedEventType() {
        return "Course";
    }

    @Override
    public void enrollParticipant(Participant participant) {
        if (!(participant instanceof Student)) {
            System.err.println("Error: Only students can enroll in courses. " +
                               (participant != null ? participant.getName() : "Unknown participant") + " is not a student.");
            return;
        }
        super.enrollParticipant(participant);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "  Workload: " + workloadHours + " hours\n";
    }
}