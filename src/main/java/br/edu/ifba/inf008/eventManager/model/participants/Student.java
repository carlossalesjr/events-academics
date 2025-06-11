package br.edu.ifba.inf008.eventManager.model.participants;

import java.time.LocalDateTime;

public class Student extends Participant {
    private String studentId;
    private String course;

    public Student(String name, String email, String phone, LocalDateTime registrationDate, String studentId, String course) {
        super(name, email, phone, registrationDate);
        this.studentId = studentId;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String getParticipantType() {
        return "Student";
    }

    @Override
    public String getParticipantId() {
        return studentId;
    }
    
}
