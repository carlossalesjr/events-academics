package br.edu.ifba.inf008.eventManager.model.participants;

import java.time.LocalDateTime;

public class External extends Participant {
    private String organization;
    private String cpf;

    public External(String name, String email, String phone, LocalDateTime registrationDate, String organization, String cpf) {
        super(name, email, phone, registrationDate);
        this.organization = organization;
        this.cpf = cpf;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getParticipantType() {
        return "External";
    }

    @Override
    public String getParticipantId() {
        return cpf;
    }
    
}
