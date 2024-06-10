package service;


import dao.abs.PassportDao;
import dto.PassportDto;
import model.Passport;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class PassportServiceTest {
    //Tests for getById
    @Test
    public void testFindByIdPassport_ThenReturnTrue(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.findById(5)).thenReturn(new Passport(1,"Alex","Alexov",2,"123qwe"));
        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        PassportDto employeeDto = passportService.getPassportById(5);
        assertEquals(employeeDto.getFirstName(),"Alex");
    }
    @Test
    public void testFindByIdPassport_ThenReturnError(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.findById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        assertThrows(IllegalArgumentException.class,()->passportService.getPassportById(-1));
    }
    //Tests for deleteById
    @Test
    public void testDeleteByIdPassport_ThenReturnTrue(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.deleteById(10)).thenReturn(true);

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        boolean result = passportService.deletePassportById(10);
        assertTrue(result);
    }
    @Test
    public void testDeleteByIdPassport_ThenReturnError(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.deleteById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        assertThrows(IllegalArgumentException.class,()->passportService.deletePassportById(-1));
    }
    //Tests for creat
    @Test
    public void testCreatePassport_ThenReturnTrue(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.create(any(Passport.class))).thenReturn(true);

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        boolean result = passportService.createPassport(new PassportDto());
        assertTrue(result);
    }
    @Test
    public void testCreatePassport_ThenReturnError(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);

        Mockito.when(mockitoPassportDao.create(null)).thenThrow(new IllegalArgumentException("object is null"));

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        assertThrows(NullPointerException.class,()->passportService.createPassport(null));
    }
    //Tests for get all employess
    @Test
    public void testGetAllPassport_ThenReturnTrue(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.all()).thenReturn(new ArrayList<>());

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        List<PassportDto> passportDtos = passportService.getAllPassports();
        assertEquals(passportDtos,new ArrayList<>());
    }

    //Tests for update
    @Test
    public void testUpdateByIdPassport_ThenReturnTrue(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.update(new Passport(),1)).thenReturn(true);

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        assertTrue(passportService.updatePassport(new PassportDto(),1));
    }
    @Test
    public void testUpdateByIdPassport_ThenReturnError(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.update(new Passport(), -2)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        assertThrows(IllegalArgumentException.class,()->passportService.updatePassport(new PassportDto(),-2));
    }
    @Test
    public void testUpdateByIdPassport_ThenReturnNullPointor(){
        PassportDao mockitoPassportDao = Mockito.mock(PassportDao.class);
        Mockito.when(mockitoPassportDao.update(null, 24)).thenThrow(new NullPointerException("id is less or equals 0"));

        PassportService passportService = new PassportServiceImpl(mockitoPassportDao);

        assertThrows(NullPointerException.class,()->passportService.updatePassport(null,24));
    }
}
