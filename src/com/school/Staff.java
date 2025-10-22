package com.school;

public class Staff extends Person {
    private String department;

    public Staff(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff, Department: " + department);
    }
}