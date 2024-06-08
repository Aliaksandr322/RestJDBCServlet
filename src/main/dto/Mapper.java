package dto;

import model.Employee;
import model.Office;
import model.Role;

import java.util.ArrayList;
import java.util.List;


public class Mapper {
    public EmployeeDto toEmployeeDto(Employee employee){
        String name = employee.getName();
        String address = employee.getAddress();
        Office office = employee.getOffice();
        List<String> roleNames = new ArrayList<>();
        for(Role role : employee.getRoleSet()){
            roleNames.add(role.getName());
        }
        return new EmployeeDto(name, address, office, roleNames);
    }

    public Employee toEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setOffice(employeeDto.getOffice());
        return employee;
    }
}
