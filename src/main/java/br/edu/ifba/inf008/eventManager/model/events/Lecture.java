package br.edu.ifba.inf008.eventManager.model.events;

import java.util.ArrayList;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class Lecture extends Event {
    private String speaker;
    private int duration;
    private boolean isOnline;

    public Lecture(String title, String description, String date, String locale, int capacity, ArrayList<Participant> participants, String speaker, int duration, boolean isOnline) {
        super(title, description, date, locale, capacity, null);
        this.speaker = speaker;
        this.duration = duration;
        this.isOnline = isOnline;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public boolean isOnline() {
        return isOnline;
    }
    
    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getEventType() {
        return "Lecture";
    }

    @Override
    public String getEventId() {
        return "L123"; // Example ID, should be generated or passed as needed
    }
    
}
