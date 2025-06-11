package br.edu.ifba.inf008.eventManager.model.events;

import java.util.ArrayList;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class Workshop extends Event {
    private String instructor;
    private int duration;

    public Workshop(String title, String description, String date, String locale, int capacity, ArrayList<Participant> participants, String instructor, int duration, boolean isOnline) {
        super(title, description, date, locale, capacity, null);
        this.instructor = instructor;
        this.duration = duration;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getEventType() {
        return "Workshop";
    }

    @Override
    public String getEventId() {
        return "W123";
    }
    
}
