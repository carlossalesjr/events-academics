package br.edu.ifba.inf008.eventManager.model.participants;

public class Professor extends Participant {
    private String department;
    private String siapeId;

    public Professor(String name, String email, String department, String siapeId) {
        super(name, email);
        this.department = department;
        this.siapeId = siapeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSiapeId() {
        return siapeId;
    }

    public void setSiapeId(String siapeId) {
        this.siapeId = siapeId;
    }

    @Override
    public String getPrimaryIdentification() {
        return siapeId;
    }
     @Override
    public String getParticipantType() {
        return "Professor";
    }
}