package br.edu.ifba.inf008.eventManager.model.participants;

import java.time.LocalDateTime;

public class Professor extends Participant {
    private String department;
    private String professorID;

    public Professor(String name, String email, String phone, LocalDateTime registrationDate, String department, String professorID) {
        super(name, email, phone, registrationDate);
        this.department = department;
        this.professorID = professorID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    @Override
    public String getParticipantType() {
        return "Professor";
    }

    @Override
    public String getParticipantId() {
        return professorID;
    }
    
}
