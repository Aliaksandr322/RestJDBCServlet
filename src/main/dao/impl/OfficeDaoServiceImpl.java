package dao.impl;

import dao.abs.OfficeDaoService;
import model.Employee;
import model.Office;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class OfficeDaoServiceImpl implements OfficeDaoService {
    @Override
    public boolean create(Office type) {
        return false;
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
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(Office type) {
        return false;
    }

    @Override
    public Set<Office> all() {
        return null;
    }
    private Office createOffice(ResultSet rs) throws SQLException {
        Office office = new Office();
        office.setId(rs.getInt("id"));
        office.setAddress(rs.getString("address"));
//        office.setEmployeeList(rs.getArray(""));
        return office;
    }

}
