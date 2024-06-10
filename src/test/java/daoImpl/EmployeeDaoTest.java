package daoImpl;

import dao.abs.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.Employee;
import model.Office;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoTest {

    //create
    @Test
    public void creatEmployeeTest(){
        Employee employee = new Employee();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        assertTrue(employeeDao.create(employee));
    }

    //all
    @Test
    public void getAllEmployeeTest(){
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        assertNotNull(employeeDao.all());
    }

    //delete
    @Test
    public void deleteEmployeeTest(){
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        assertTrue(employeeDao.deleteById(100));
    }

    //get by id
    @Test
    public void getByIdEmployeeTest(){
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        assertEquals(employeeDao.findById(6).getName(), "Bob");
    }
    @Test
    public void updateByIdEmployeeTest(){
        Employee employee = new Employee();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        assertTrue(employeeDao.update(employee,15));
    }

}
