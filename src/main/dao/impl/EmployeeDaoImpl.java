package dao.impl;

import dao.abs.EmployeeDao;
import dao.abs.OfficeDao;
import dao.abs.PassportDao;
import dao.abs.RoleDao;
import model.EmpRole;
import model.Employee;
import model.Passport;
import model.Role;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    private final static OfficeDao officeDao = new OfficeDaoImpl();
    private final static PassportDao passportDao = new PassportDaoImpl();
    private final static RoleDao roleDao = new RoleDaoImpl();
    private final static int DEFAULT_OFFICE = 1;
    @Override
    public boolean create(Employee employee) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            Passport castomPassport = new Passport(0, "name", "lastName", 1, "personalId");
            passportDao.create(castomPassport);
            int passportCastomId = (passportDao.all().get(passportDao.all().size() - 1)).getId();
            String sql = "INSERT INTO `employee` (`id`, `name`, `address`, `passport_id`, `office_id` ) " +
                    "VALUES ('" + employee.getId() + "', '" + employee.getName() + "', '" + employee.getAddress() + "', '"
                    + passportCastomId + "', '" +
                    DEFAULT_OFFICE + "')";
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
    public boolean update(Employee employee, int id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            boolean result = statement.execute("UPDATE employee SET name = '"+employee.getName()+"'," +
                    " address = '" + employee.getAddress() + "' WHERE id = " + id);
            return !result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> all() {
        List<Employee> employees = new ArrayList<>();

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
        employee.setAddress(rs.getString("address"));
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
            statement.executeUpdate("DELETE FROM empls_roles WHERE empl_id = " + emplId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
