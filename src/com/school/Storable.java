package com.school;

public interface Storable {
    /**
     * Return a single-line string representation suitable for file persistence (CSV style).
     */
    String toDataString();
}
