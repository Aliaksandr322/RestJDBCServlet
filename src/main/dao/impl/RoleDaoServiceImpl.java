package dao.impl;

import dao.abs.RoleDaoService;
import model.Employee;
import model.Role;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleDaoServiceImpl implements RoleDaoService {
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
    public boolean update(Role type) {
        return false;
    }

    @Override
    public Set<Role> all() {
        return null;
    }

    private Role createRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        return role;
    }
}
