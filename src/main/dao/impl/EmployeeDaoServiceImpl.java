package dao.impl;

import dao.abs.EmployeeDaoService;
import dao.abs.OfficeDaoService;
import dao.abs.PassportDaoService;
import dao.abs.RoleDaoService;
import model.EmpRole;
import model.Employee;
import model.Role;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDaoServiceImpl implements EmployeeDaoService {

    private final static OfficeDaoService officeDao = new OfficeDaoServiceImpl();
    private final static PassportDaoService passportDao = new PassportDaoServiceImpl();
    private final static RoleDaoService roleDao = new RoleDaoServiceImpl();
    @Override
    public boolean create(Employee employee) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            String sql = "INSERT INTO `employees` (`id`, `name`, `address`, `passport_id`, `office_id` ) " +
                    "VALUES ('" + employee.getId() + "', '" + employee.getName() + "', '" + employee.getPassport().getId() + "', '" +
                    employee.getOffice().getId() + "')";
            int count = statement.executeUpdate(sql);
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findById(Integer id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery("SELECT * FROM employee where id =" + id);
            if (rs.next()) {
                return createEmployee(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            deleteFromEmplRole(id);
            statement.execute("DELETE FROM employee where id =" + id);
            if (findById(id) == null) {
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Employee employee) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            statement.execute("UPDATE employees SET name = '"+employee.getName()+"'," +
                    " office_id = '" + employee.getOffice().getId() + "', passport_id = '" +
                    employee.getPassport().getId() + "' WHERE id = " + employee.getId());
            if (findById(employee.getId()).equals(employee)) {
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Employee> all() {
        Set<Employee> employees = new HashSet<>();

        try (Connection connection = JDBCConnection.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                employees.add(createEmployee(rs));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Employee createEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setOffice(officeDao.findById(rs.getInt("office_id")));
        employee.setPassport(passportDao.findById(rs.getInt("passport_id")));
        List<Integer> roleList = getRoleSetByEmplId(employee.getId());
        List<Role> roles = new ArrayList<>();
        for(Integer roleId : roleList){
            roles.add(roleDao.findById(roleId));
        }
        employee.setRoleSet(roles);
        return employee;
    }

    private List<Integer> getRoleSetByEmplId(Integer emplId){
        List<Integer> roleList = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery("SELECT * FROM empls_roles where empl_id = " + emplId);
            while (rs.next()) {
                EmpRole empRole = empRole(rs);
                roleList.add(empRole.getRoleId());
            }
            return roleList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private EmpRole empRole(ResultSet rs) throws SQLException {
        EmpRole empRole = new EmpRole();
        empRole.setEmpId(rs.getInt("empl_id"));
        empRole.setRoleId(rs.getInt("role_id"));
        return empRole;
    }
    private void deleteFromEmplRole(Integer emplId){
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            int count = statement.executeUpdate("DELETE FROM empls_roles WHERE empl_id = " + emplId);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
