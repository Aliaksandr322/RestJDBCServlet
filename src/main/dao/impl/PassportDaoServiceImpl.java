package dao.impl;

import dao.abs.PassportDaoService;
import model.Employee;
import model.Passport;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class PassportDaoServiceImpl implements PassportDaoService {
    @Override
    public boolean create(Passport type) {
        return false;
    }

    @Override
    public Passport findById(Integer id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery("SELECT * FROM passport where id =" + id);
            if (rs.next()) {
                return createEmployee(rs);
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
    public boolean update(Passport type) {
        return false;
    }

    @Override
    public Set<Passport> all() {
        return null;
    }

    private Passport createEmployee(ResultSet rs) throws SQLException {
        Passport passport = new Passport();
        passport.setId(rs.getInt("id"));
        passport.setFirstName(rs.getString("first_name"));
        passport.setLastName(rs.getString("last_name"));
        passport.setInitId(rs.getInt("init_id"));
        passport.setPersonalId(rs.getString("personal_id"));
        return passport;
    }
}
