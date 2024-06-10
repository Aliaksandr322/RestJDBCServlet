package service;


import dao.abs.EmployeeDao;
import dao.abs.PassportDao;
import dao.abs.RoleDao;
import dao.impl.EmployeeDaoImpl;
import dao.impl.RoleDaoImpl;
import dto.EmployeeDto;
import model.Employee;
import model.Office;
import model.Passport;
import model.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class EmployeeServiceTest {

    //Tests for getById
    @Test
    public void testFindByIdEmployee_ThenReturnTrue(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.findById(5)).thenReturn(new Employee(1,"John", "dqwdqwdq", new Office(2,"str.KarlaMarksa 43", null),new Passport(),new ArrayList<>()));

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        EmployeeDto employeeDto = employeeService.getEmployeeById(5);
        assertEquals(employeeDto.getName(),"John");
    }
    @Test
    public void testFindByIdEmployee_ThenReturnError(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.findById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        assertThrows(IllegalArgumentException.class,()->employeeService.getEmployeeById(-1));
    }
    //Tests for deleteById
    @Test
    public void testDeleteByIdEmployee_ThenReturnTrue(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.deleteById(5)).thenReturn(true);

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        boolean result = employeeService.deleteEmployeeById(5);
        assertTrue(result);
    }
    @Test
    public void testDeleteByIdEmployee_ThenReturnError(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.deleteById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        assertThrows(IllegalArgumentException.class,()->employeeService.deleteEmployeeById(-1));
    }
    //Tests for creat
    @Test
    public void testCreateEmployee_ThenReturnTrue(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.create(any(Employee.class))).thenReturn(true);

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        boolean result = employeeService.createEmployee(new EmployeeDto());
        assertTrue(result);
    }
    @Test
    public void testCreateEmployee_ThenReturnError(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);

        Mockito.when(mockitoEmployeeDao.create(null)).thenThrow(new IllegalArgumentException("object is null"));

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        assertThrows(NullPointerException.class,()->employeeService.createEmployee(null));
    }
    //Tests for get all employess
    @Test
    public void testGetAllEmployee_ThenReturnTrue(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.all()).thenReturn(new ArrayList<>());

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();
        assertEquals(employeeDtos,new ArrayList<>());
    }

    //Tests for update
    @Test
    public void testUpdateByIdEmployee_ThenReturnTrue(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.update(new Employee(),24)).thenReturn(true);

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        assertFalse(employeeService.updateEmployee(new EmployeeDto(),24));
    }
    @Test
    public void testUpdateByIdEmployee_ThenReturnError(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.update(new Employee(), -2)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        assertThrows(IllegalArgumentException.class,()->employeeService.updateEmployee(new EmployeeDto(),-2));
    }
    @Test
    public void testUpdateByIdEmployee_ThenReturnNullPointor(){
        EmployeeDao mockitoEmployeeDao = Mockito.mock(EmployeeDao.class);
        RoleDao mockitoPassportDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoEmployeeDao.update(null, 24)).thenThrow(new NullPointerException("id is less or equals 0"));

        EmployeeService employeeService = new EmployeeServiceImpl(mockitoEmployeeDao,mockitoPassportDao);

        assertThrows(NullPointerException.class,()->employeeService.updateEmployee(null,24));
    }
}
