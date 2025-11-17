package com.school;

public class Student extends Person implements Storable {
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        super(id, name);
        this.age = age;
        this.grade = grade;
    }

    public int getAge() { return age; }
    public String getGrade() { return grade; }

    @Override
    public String toDataString() {
        // CSV-like: id,name,age,grade
        return String.format("%d,%s,%d,%s", id, escape(name), age, escape(grade));
    }

    private String escape(String s) {
        return s == null ? "" : s.replace(",", "\\,");
    }
}
