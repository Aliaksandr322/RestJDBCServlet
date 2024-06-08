package dto;

import model.Office;

import java.util.List;
import java.util.Objects;

public class EmployeeDto {

    private String name;
    private String address;
    private Office office;
    private List<String> roleName;

    public EmployeeDto(String name, String address, Office office, List<String> roleName) {
        this.name = name;
        this.address = address;
        this.office = office;
        this.roleName = roleName;
    }

    public EmployeeDto(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(office, that.office) && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, office, roleName);
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

    public List<String> getRoleSet() {
        return roleName;
    }

    public void setRoleSet(List<String> roleSet) {
        this.roleName = roleSet;
    }
}
