package br.edu.ifba.inf008.eventManager.model.events;

import java.util.ArrayList;

import br.edu.ifba.inf008.eventManager.model.participants.Participant;

public class Fair extends Event {
    private String theme;
    private String[] exhibitors;

    public Fair(String title, String description, String date, String locale, int capacity, ArrayList<Participant> participants, String theme, String[] exhibitors) {
        super(title, description, date, locale, capacity, null);
        this.theme = theme;
        this.exhibitors = exhibitors;
    }

    public String gettheme() {
        return theme;
    }

    public void settheme(String theme) {
        this.theme = theme;
    }

    public String[] getExhibitors() {
        return exhibitors;
    }

    public void setExhibitors(String[] exhibitors) {
        this.exhibitors = exhibitors;
    }

    @Override
    public String getEventType() {
        return "Fair";
    }

    @Override
    public String getEventId() {
        return "F123"; // Example ID, should be generated or passed as needed
    }
    
}
