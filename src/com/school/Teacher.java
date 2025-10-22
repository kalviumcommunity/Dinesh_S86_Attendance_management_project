package com.school;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher, Subject: " + subject);
    }
}