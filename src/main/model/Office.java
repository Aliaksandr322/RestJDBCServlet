package model;

import java.util.List;
import java.util.Objects;

public class Office {

    private int id;
    private String address;
    private String updatedTs;
    private String createdTs;
    //TODO Many to One employee
    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return id == office.id && Objects.equals(address, office.address) && Objects.equals(updatedTs, office.updatedTs) && Objects.equals(createdTs, office.createdTs) && Objects.equals(employeeList, office.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, updatedTs, createdTs, employeeList);
    }

    public Office(int id, String address, String updatedTs, String createdTs, List<Employee> employeeList) {
        this.id = id;
        this.address = address;
        this.updatedTs = updatedTs;
        this.createdTs = createdTs;
        this.employeeList = employeeList;
    }
}
