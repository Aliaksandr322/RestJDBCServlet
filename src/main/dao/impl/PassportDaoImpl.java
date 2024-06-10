package dao.impl;

import dao.abs.PassportDao;
import model.Passport;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassportDaoImpl implements PassportDao {
    @Override
    public boolean create(Passport passport) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            String sql = "INSERT INTO `passport` (`id`, `first_name`, `last_name`, `init_id`, `personal_id` ) " +
                    "VALUES ('" + passport.getId() + "', '" + passport.getFirstName() + "', '" + passport.getLastName() + "', " +
                    "'" + passport.getInitId() + "'" +
                    ", '" + passport.getPersonalId() + "')";
            int count = statement.executeUpdate(sql);
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Passport findById(Integer id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery("SELECT * FROM passport where id =" + id);
            if (rs.next()) {
                return createPassport(rs);
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
            statement.execute("DELETE FROM passport where id =" + id);
            if (findById(id) == null) {
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Passport passport, int id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            boolean result = statement.execute("UPDATE passport SET first_name = '"+passport.getFirstName()+"'," +
                    " last_name = '" + passport.getLastName() + "',"+"init_id = '" + passport.getInitId() + "',"
                    + " personal_id ='" + passport.getPersonalId()
                    + "' WHERE id = " + id);
            return !result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Passport> all() {
        List<Passport> passports = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM passport");
            while (rs.next()) {
                passports.add(createPassport(rs));
            }
            return passports;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Passport createPassport(ResultSet rs) throws SQLException {
        Passport passport = new Passport();
        passport.setId(rs.getInt("id"));
        passport.setFirstName(rs.getString("first_name"));
        passport.setLastName(rs.getString("last_name"));
        passport.setInitId(rs.getInt("init_id"));
        passport.setPersonalId(rs.getString("personal_id"));
        return passport;
    }
}
