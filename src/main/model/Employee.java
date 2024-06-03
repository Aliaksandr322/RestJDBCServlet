package model;

import java.sql.Date;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String address;
    private Date createTs;
    private Date updateTs;
    //TODO Many to One
    private Office office;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(createTs, employee.createTs) && Objects.equals(updateTs, employee.updateTs) && Objects.equals(office, employee.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, createTs, updateTs, office);
    }

    public Employee(int id, String name, String address, Date createTs, Date updateTs, Office office) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.createTs = createTs;
        this.updateTs = updateTs;
        this.office = office;
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

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
