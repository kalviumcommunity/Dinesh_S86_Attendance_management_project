package com.school;

public class Teacher extends Person implements Storable {
    private String subject;

    public Teacher(int id, String name, String subject) {
        super(id, name);
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    @Override
    public String toDataString() {
        // CSV-like: id,name,subject
        return String.format("%d,%s,%s", id, escape(name), escape(subject));
    }

    private String escape(String s) {
        return s == null ? "" : s.replace(",", "\\,");
    }
}
