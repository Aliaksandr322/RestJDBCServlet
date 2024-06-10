package dao.impl;

import dao.abs.OfficeDao;
import dto.EmployeeDto;
import model.Office;
import model.Passport;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfficeDaoImpl implements OfficeDao {
    @Override
    public boolean create(Office office) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            String sql = "INSERT INTO `office` (`id`, `address`) " +
                    "VALUES ('" + office.getId() + "', '" + office.getAddress() + "')";
            int count = statement.executeUpdate(sql);
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Office findById(Integer id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM office where id =" + id);
            if (rs.next()) {
                return createOffice(rs);
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
            statement.execute("DELETE FROM office where id =" + id);
            if (findById(id) == null) {
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Office office, int id) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            boolean result = statement.execute("UPDATE office SET address = '"+ office.getAddress() + "' WHERE id = " + id);
            return !result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Office> all() {
        List<Office> offices = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM office");
            while (rs.next()) {
                offices.add(createOffice(rs));
            }
            return offices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Office createOffice(ResultSet rs) throws SQLException {
        Office office = new Office();
        office.setId(rs.getInt("id"));
        office.setAddress(rs.getString("address"));
        return office;
    }
}
