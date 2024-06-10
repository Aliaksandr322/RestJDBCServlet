package dao.impl;

import dao.abs.RoleDao;
import model.Role;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public boolean create(Role type) {
        return false;
    }

    @Override
    public Role findById(Integer id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery("SELECT * FROM role where id =" + id);
            if (rs.next()) {
                return createRole(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(Role type, int id) {
        return false;
    }

    @Override
    public List<Role> all() {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM role");
            while (rs.next()) {
                roles.add(createRole(rs));
            }
            return roles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Role findByName(String name) {
        return null;
    }

    @Override
    public List<Role> findAllRolesByName(List<String> roleNames) {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            if(roleNames == null){
                return new ArrayList<>();
            }
            for(String roleName : roleNames) {
                ResultSet rs = statement.executeQuery("SELECT * FROM role WHERE name = " + roleName);
                while (rs.next()) {
                    roles.add(createRole(rs));
                }
            }
            return roles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Role createRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        return role;
    }

}
