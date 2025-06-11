package br.edu.ifba.inf008.eventManager.model.events;

import java.util.ArrayList;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class Course extends Event {
    private String instructor;
    private int duration;
    private boolean isOnline;

    public Course(String title, String description, String date, String locale, int capacity, ArrayList<Participant> participants ,String instructor, int duration, boolean isOnline) {
        super(title, description, date, locale, capacity, null);
        this.instructor = instructor;
        this.duration = duration;
        this.isOnline = isOnline;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    @Override
    public String getEventType() {
        return "Course";
    }

    @Override
    public String getEventId() {
        return "C123"; // Example ID, should be generated or passed as needed
    }
}
