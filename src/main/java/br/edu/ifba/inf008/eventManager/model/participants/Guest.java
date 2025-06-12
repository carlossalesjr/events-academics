package br.edu.ifba.inf008.eventManager.model.participants;

public class Guest extends Participant {
    private String affiliatedOrganization;
    private String nationalId;

    public Guest(String name, String email, String affiliatedOrganization, String nationalId) {
        super(name, email);
        this.affiliatedOrganization = affiliatedOrganization;
        this.nationalId = nationalId;
    }

    public String getAffiliatedOrganization() {
        return affiliatedOrganization;
    }

    public void setAffiliatedOrganization(String affiliatedOrganization) {
        this.affiliatedOrganization = affiliatedOrganization;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @Override
    public String getPrimaryIdentification() {
        return nationalId;
    }

    @Override
    public String getParticipantType() {
        return "Guest";
    }
}