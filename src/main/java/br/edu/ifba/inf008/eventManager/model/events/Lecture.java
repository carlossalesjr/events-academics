package br.edu.ifba.inf008.eventManager.model.events;

import java.time.LocalDate;

public class Lecture extends Event {
    private String speaker;

    public Lecture(String title, LocalDate date, String location, int maxCapacity, String description, String speaker) {
        super(title, date, location, maxCapacity, description);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    @Override
    public String getDetailedEventType() {
        return "Lecture";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "  Speaker: " + speaker;
    }
}