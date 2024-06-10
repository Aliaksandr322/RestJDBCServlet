package dto;

import model.Employee;

import java.util.List;
import java.util.Objects;

public class OfficeDto {
    private String address;
    private List<Employee> employeeList;
    public OfficeDto(){}

    public OfficeDto(String address, List<Employee> employeeList) {
        this.address = address;
        this.employeeList = employeeList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        OfficeDto officeDto = (OfficeDto) o;
        return Objects.equals(address, officeDto.address) && Objects.equals(employeeList, officeDto.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, employeeList);
    }
}
