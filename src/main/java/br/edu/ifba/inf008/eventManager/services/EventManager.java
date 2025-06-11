package br.edu.ifba.inf008.eventManager.services;
import java.util.ArrayList;

import br.edu.ifba.inf008.eventManager.model.events.Event;

public class EventManager {
    private ArrayList<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public Event getEventById(String id) {
        for (Event event : events) {
            if (event.getEventId().equals(id)) {
                return event;
            }
        }
        return null; 
    }
    
    public ArrayList<Event> getEventsByType(String type) {
        ArrayList<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventType().equalsIgnoreCase(type)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }  
    


}
