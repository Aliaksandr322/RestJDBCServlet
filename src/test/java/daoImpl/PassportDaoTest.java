package daoImpl;

import dao.abs.PassportDao;
import dao.impl.PassportDaoImpl;
import model.Passport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassportDaoTest {
    //create
    @Test
    public void creatPassportTest(){
        Passport passport = new Passport();
        PassportDao passportDao = new PassportDaoImpl();
        assertTrue(passportDao.create(passport));
    }

    @Test
    public void getAllPassportTest(){
        PassportDao passportDao = new PassportDaoImpl();
        assertNotNull(passportDao.all());
    }

    //delete
    @Test
    public void deletePassportTest(){
        PassportDao passportDao = new PassportDaoImpl();
        assertTrue(passportDao.deleteById(100));
    }

    //get by id
    @Test
    public void getByIdPassportTest(){
        PassportDao passportDao = new PassportDaoImpl();
        assertEquals(passportDao.findById(1).getFirstName(), "Bob");
    }
    @Test
    public void updateByIdPassportTest(){
        Passport passport = new Passport();
        PassportDao passportDao = new PassportDaoImpl();
        assertTrue(passportDao.update(passport,15));
    }
}
