package br.edu.ifba.inf008.eventManager.model.participants;

import java.util.Objects;

public abstract class Participant {
    private String name;
    private String email;

    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getPrimaryIdentification();
    public abstract String getParticipantType();


    @Override
    public String toString() {
        return "Participant: " + name + " (" + email + ") - Type: " + getParticipantType() + ", ID: " + getPrimaryIdentification();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}