package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(int id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    public String getRole() { return role; }

    @Override
    public String toDataString() {
        // CSV-like: id,name,role
        return String.format("%d,%s,%s", id, escape(name), escape(role));
    }

    private String escape(String s) {
        return s == null ? "" : s.replace(",", "\\,");
    }
}
    