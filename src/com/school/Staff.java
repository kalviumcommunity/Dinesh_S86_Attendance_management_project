package com.school;

public class Staff extends Person {
    private String role;

    public Staff(String name, String role) {
        super(name); // matches Person(String name)
        this.role = role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: " + role);
    }
}
