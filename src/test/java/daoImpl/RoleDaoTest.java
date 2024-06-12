package daoImpl;

import dao.abs.PassportDao;
import dao.abs.RoleDao;
import dao.impl.PassportDaoImpl;
import dao.impl.RoleDaoImpl;
import model.Passport;
import model.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoleDaoTest {
    //create
    @Test
    public void creatRoleTest(){
        Role role = new Role();
        RoleDao roleDao = new RoleDaoImpl();
        assertTrue(roleDao.create(role));
    }

    @Test
    public void getAllRoleTest(){
        RoleDao roleDao = new RoleDaoImpl();
        assertNotNull(roleDao.all());
    }

    //delete
    @Test
    public void deleteRoleTest(){
        RoleDao roleDao = new RoleDaoImpl();
        assertTrue(roleDao.deleteById(100));
    }

    //get by id
    @Test
    public void getByIdRoleTest(){
        RoleDao roleDao = new RoleDaoImpl();
        assertEquals(roleDao.findById(2).getName(), "Manager");
    }
    @Test
    public void updateByIdRoleTest(){
        Role role = new Role();
        RoleDao roleDao = new RoleDaoImpl();
        assertTrue(roleDao.update(role,3));
    }
}
