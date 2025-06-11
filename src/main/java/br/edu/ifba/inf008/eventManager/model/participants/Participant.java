package br.edu.ifba.inf008.eventManager.model.participants;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Participant {
    private String name;
    private String email;
    private String phone;
    private LocalDateTime registrationDate;

    public Participant(String name, String email, String phone, LocalDateTime registrationDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public abstract String getParticipantType();

    public abstract String getParticipantId();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return name.equals(that.name) && email.equals(that.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

}
