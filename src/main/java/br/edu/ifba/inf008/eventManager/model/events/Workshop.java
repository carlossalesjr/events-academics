package br.edu.ifba.inf008.eventManager.model.events;

import java.time.LocalDate;

public class Workshop extends Event {
    private String instructor;

    public Workshop(String title, LocalDate date, String location, int maxCapacity, String description, String instructor) {
        super(title, date, location, maxCapacity, description);
        this.instructor = instructor;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String getDetailedEventType() {
        return "Workshop";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "  Instructor: " + instructor;
    }
}