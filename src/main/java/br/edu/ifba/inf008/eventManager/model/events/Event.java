package br.edu.ifba.inf008.eventManager.model.events;
import java.util.ArrayList;
import java.util.Objects;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public abstract class Event {
    private String title;
    private String description;
    private String date;
    private String locale;
    private int capacity;
    private ArrayList<Participant> participants;

    public Event(String title, String description, String date, String locale, int capacity, ArrayList<Participant> participants) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.locale = locale;
        this.capacity = capacity;
        this.participants = participants;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }
    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public abstract String getEventType();

    public abstract String getEventId();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return Objects.equals(title, event.title) &&
               Objects.equals(date, event.date);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }
}
