package service;

import dto.EmployeeDto;
import model.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeById(int id);
    List<EmployeeDto> getAllEmployee();
    boolean deleteEmployeeById(int id);
    boolean createEmployee(EmployeeDto employeeDto);
    boolean updateEmployee(EmployeeDto employeeDto, int id);

}
