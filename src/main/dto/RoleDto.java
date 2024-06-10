package dto;

import model.Employee;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class RoleDto {

    private String name;
    private List<Employee> employeesSet;

    public RoleDto(String name, List<Employee> employeesSet) {
        this.name = name;
        this.employeesSet = employeesSet;
    }
    public RoleDto(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(name, roleDto.name) && Objects.equals(employeesSet, roleDto.employeesSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employeesSet);
    }

    public JSONObject doWork(String output) {
        return new JSONObject(output);
    }
}
