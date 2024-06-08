package model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Employee {

    private int id;
    private String name;
    private String address;
    //Many to One
    private Office office;
    //One to One
    private Passport passport;
    // Many to Many
    private List<Role> roleSet;

    public Employee(int id, String name, String address, Office office, Passport passport, List<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.office = office;
        this.passport = passport;
        this.roleSet = roleSet;
    }
    public Employee(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(List<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(office, employee.office) && Objects.equals(passport, employee.passport) && Objects.equals(roleSet, employee.roleSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, office, passport, roleSet);
    }
}
