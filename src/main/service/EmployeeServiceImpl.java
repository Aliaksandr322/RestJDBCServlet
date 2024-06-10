package service;

import dao.abs.EmployeeDao;
import dao.abs.RoleDao;
import dto.EmployeeDto;
import model.Employee;
import model.Office;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private static EmployeeDao employeeDao;
    private static RoleDao roleDao;

    public EmployeeServiceImpl (EmployeeDao employeeDao, RoleDao roleDao){
        this.employeeDao = employeeDao;
        this.roleDao = roleDao;
    }

    @Override
    public EmployeeDto getEmployeeById(int id) {
        if(id <= 0) throw new IllegalArgumentException("id is less or equals 0");
        EmployeeDto employeeDto = toEmployeeDto(employeeDao.findById(id));
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employeeDtos= new ArrayList<>();
        List<Employee> employees = employeeDao.all();
        for(Employee e : employees){
            employeeDtos.add(toEmployeeDto(e));
        }
        return employeeDtos;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        if(id <= 0) throw new IllegalArgumentException("id is less or equals 0");
        return employeeDao.deleteById(id);
    }

    @Override
    public boolean createEmployee(EmployeeDto employeeDto) {
        if(employeeDto == null){
            throw new NullPointerException("object is null");
        }
        Employee employee = toEmployee(employeeDto);
        return employeeDao.create(employee);
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto, int id) {
        if(employeeDto == null){
            throw new NullPointerException("object is null");
        }
        if(id <= 0) throw new IllegalArgumentException("id is less or equals 0");
        Employee employee = toEmployee(employeeDto);
        return employeeDao.update(employee,id);
    }

    private static EmployeeDto toEmployeeDto(Employee employee){
        String name = employee.getName();
        String address = employee.getAddress();
        Office office = employee.getOffice();
        List<String> roleNames = new ArrayList<>();
        for(Role role : employee.getRoleSet()){
            roleNames.add(role.getName());
        }
        return new EmployeeDto(name, address, office, roleNames);
    }

    private static Employee toEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setOffice(employeeDto.getOffice());
        employee.setRoleSet(roleDao.findAllRolesByName(employeeDto.getRoleSet()));
        return employee;
    }
}
