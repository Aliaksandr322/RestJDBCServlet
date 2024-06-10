package model;

import java.util.List;
import java.util.Set;

public class Role {
    private int id;
    private String name;
    //TODO Many to Many
    private List<Employee> employeesSet;

    public Role(int id, String name, List<Employee> employeesSet) {
        this.id = id;
        this.name = name;
        this.employeesSet = employeesSet;
    }

    public Role(){}

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

    public List<Employee> getEmployeesSet() {
        return employeesSet;
    }

    public void setEmployeesSet(List<Employee> employeesSet) {
        this.employeesSet = employeesSet;
    }
}
