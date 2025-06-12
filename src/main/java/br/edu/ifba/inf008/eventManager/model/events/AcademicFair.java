package br.edu.ifba.inf008.eventManager.model.events;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class AcademicFair extends Event {
    private String mainTheme;
    private List<String> organizers;

    public AcademicFair(String title, LocalDate date, String location, int maxCapacity, String description, String mainTheme, List<String> organizers) {
        super(title, date, location, maxCapacity, description);
        this.mainTheme = mainTheme;
        this.organizers = organizers!= null? new ArrayList<>(organizers) : new ArrayList<>();
    }

    public String getMainTheme() {
        return mainTheme;
    }

    public void setMainTheme(String mainTheme) {
        this.mainTheme = mainTheme;
    }

    public List<String> getOrganizers() {
        return new ArrayList<>(organizers);
    }

    public void setOrganizers(List<String> organizers) {
        this.organizers = organizers!= null? new ArrayList<>(organizers) : new ArrayList<>();
    }

    public void addOrganizer(String organizer) {
        if (organizer!= null &&!organizer.trim().isEmpty()) {
            this.organizers.add(organizer);
        }
    }

    @Override
    public String getDetailedEventType() {
        return "Academic Fair";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "  Main Theme: " + mainTheme + "\n" +
               "  Organizers: " + String.join(", ", organizers);
    }
}