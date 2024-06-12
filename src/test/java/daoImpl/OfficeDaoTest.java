package daoImpl;

import dao.abs.OfficeDao;
import dao.impl.OfficeDaoImpl;
import model.Office;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OfficeDaoTest {
    //create
    @Test
    public void creatOfficeTest(){
        Office office = new Office();
        OfficeDao officeDao = new OfficeDaoImpl();
        assertTrue(officeDao.create(office));
    }

    @Test
    public void getAllOfficeTest(){
        OfficeDao officeDao = new OfficeDaoImpl();
        assertNotNull(officeDao.all());
    }

    //delete
    @Test
    public void deleteOfficeTest(){
        OfficeDao officeDao = new OfficeDaoImpl();
        assertTrue(officeDao.deleteById(100));
    }

    //get by id
    @Test
    public void getByIdOfficeTest(){
        OfficeDao officeDao = new OfficeDaoImpl();
        assertEquals("KarlaMarksa 35", officeDao.findById(2).getAddress());
    }
    @Test
    public void updateByIdOfficeTest(){
        Office office = new Office();
        OfficeDao officeDao = new OfficeDaoImpl();
        assertTrue(officeDao.update(office,4));
    }
}
