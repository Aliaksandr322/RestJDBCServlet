package model;

import java.util.Objects;

public class Passport {

    private int id;
    private String firstName;
    private String lastName;
    private int initId;
    private String personalId;
    public Passport(){}

    public Passport(int id, String firstName, String lastName, int initId, String personalId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initId = initId;
        this.personalId = personalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getInitId() {
        return initId;
    }

    public void setInitId(int initId) {
        this.initId = initId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id && initId == passport.initId && Objects.equals(firstName, passport.firstName) && Objects.equals(lastName, passport.lastName) && Objects.equals(personalId, passport.personalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, initId, personalId);
    }
}
