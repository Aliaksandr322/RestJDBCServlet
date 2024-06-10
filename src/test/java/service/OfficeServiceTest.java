package service;

import dao.abs.OfficeDao;
import dao.abs.PassportDao;
import dto.OfficeDto;
import dto.PassportDto;
import model.Office;
import model.Passport;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class OfficeServiceTest {
    //Tests for getById
    @Test
    public void testFindByIdOffice_ThenReturnTrue(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.findById(5)).thenReturn(new Office(1,"KarlaMarksa42",new ArrayList<>()));
        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        OfficeDto officeDto = officeService.getOfficeById(5);
        assertEquals(officeDto.getAddress(),"KarlaMarksa42");
    }
    @Test
    public void testFindByIdOffice_ThenReturnError(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.findById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        assertThrows(IllegalArgumentException.class,()->officeService.getOfficeById(-1));
    }
    //Tests for deleteById
    @Test
    public void testDeleteByIdOffice_ThenReturnTrue(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.deleteById(10)).thenReturn(true);

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        boolean result = officeService.deleteOfficeById(10);
        assertTrue(result);
    }
    @Test
    public void testDeleteByIdOffice_ThenReturnError(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.deleteById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        assertThrows(IllegalArgumentException.class,()->officeService.deleteOfficeById(-1));
    }
    //Tests for creat
    @Test
    public void testCreateOffice_ThenReturnTrue(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.create(any(Office.class))).thenReturn(true);

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        boolean result = officeService.createOffice(new OfficeDto());
        assertTrue(result);
    }
    @Test
    public void testCreateOffice_ThenReturnError(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);

        Mockito.when(mockitoOfficeDao.create(null)).thenThrow(new IllegalArgumentException("object is null"));

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        assertThrows(NullPointerException.class,()->officeService.createOffice(null));
    }
    //Tests for get all employess
    @Test
    public void testGetAllOffice_ThenReturnTrue(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.all()).thenReturn(new ArrayList<>());

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        List<OfficeDto> officeDtos = officeService.getAllOffices();
        assertEquals(officeDtos,new ArrayList<>());
    }

    //Tests for update
    @Test
    public void testUpdateByIdOffice_ThenReturnTrue(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.update(new Office(),1)).thenReturn(true);

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        assertFalse(officeService.updateOffice(new OfficeDto(),1));
    }
    @Test
    public void testUpdateByIdOffice_ThenReturnError(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.update(new Office(), -2)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        assertThrows(IllegalArgumentException.class,()->officeService.updateOffice(new OfficeDto(),-2));
    }
    @Test
    public void testUpdateByIdOffice_ThenReturnNullPointor(){
        OfficeDao mockitoOfficeDao = Mockito.mock(OfficeDao.class);
        Mockito.when(mockitoOfficeDao.update(null, 24)).thenThrow(new NullPointerException("id is less or equals 0"));

        OfficeService officeService = new OfficeServiceImpl(mockitoOfficeDao);

        assertThrows(NullPointerException.class,()->officeService.updateOffice(null,24));
    }
}
