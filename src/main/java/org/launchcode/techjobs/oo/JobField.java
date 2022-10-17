package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private final int id;
    private static int nextID = 1;
    private String value;

    protected JobField() {
        this.id = nextID;
        nextID++;
    }

    protected JobField(String aValue){
        this();
        this.value = aValue;
    }

    @Override
    public String toString() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
