package model;

import java.util.Objects;

public class Passport {

    private int id;
    private String firstName;
    private String lastName;
    private long initId;
    private String personalId;
    //TODO One to One employee
    private Employee employee;
    private String updatedTs;
    private String createdTs;

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

    public long getInitId() {
        return initId;
    }

    public void setInitId(long initId) {
        this.initId = initId;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id && initId == passport.initId && Objects.equals(firstName, passport.firstName) && Objects.equals(lastName, passport.lastName) && Objects.equals(personalId, passport.personalId) && Objects.equals(employee, passport.employee) && Objects.equals(updatedTs, passport.updatedTs) && Objects.equals(createdTs, passport.createdTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, initId, personalId, employee, updatedTs, createdTs);
    }

    public Passport(int id, String firstName, String lastName, long initId, String personalId, Employee employee, String updatedTs, String createdTs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initId = initId;
        this.personalId = personalId;
        this.employee = employee;
        this.updatedTs = updatedTs;
        this.createdTs = createdTs;
    }

    public String getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(String updatedTs) {
        this.updatedTs = updatedTs;
    }

    public String getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(String createdTs) {
        this.createdTs = createdTs;
    }
}
