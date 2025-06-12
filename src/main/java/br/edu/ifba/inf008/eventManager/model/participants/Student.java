package br.edu.ifba.inf008.eventManager.model.participants;

public class Student extends Participant {
    private String registrationId;
    private String enrolledCourse;

    public Student(String name, String email, String registrationId, String enrolledCourse) {
        super(name, email);
        this.registrationId = registrationId;
        this.enrolledCourse = enrolledCourse;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    @Override
    public String getPrimaryIdentification() {
        return registrationId;
    }

    @Override
    public String getParticipantType() {
        return "Student";
    }
}