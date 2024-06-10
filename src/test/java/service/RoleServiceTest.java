package service;

import dao.abs.PassportDao;
import dao.abs.RoleDao;
import dto.PassportDto;
import dto.RoleDto;
import model.Passport;
import model.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class RoleServiceTest {
    @Test
    public void testFindByIdRole_ThenReturnTrue(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.findById(5)).thenReturn(new Role(1,"Manager",new ArrayList<>()));

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        RoleDto roleDto = roleService.getRoleById(5);
        assertEquals(roleDto.getName(),"Manager");
    }
    @Test
    public void testFindByIdRole_ThenReturnError(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.findById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        assertThrows(IllegalArgumentException.class,()->roleService.getRoleById(-1));
    }
    //Tests for deleteById
    @Test
    public void testDeleteByIdRole_ThenReturnTrue(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.deleteById(10)).thenReturn(true);

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        boolean result = roleService.deleteRoleById(10);
        assertTrue(result);
    }
    @Test
    public void testDeleteByIdRole_ThenReturnError(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.deleteById(-1)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        assertThrows(IllegalArgumentException.class,()->roleService.deleteRoleById(-1));
    }
    //Tests for creat
    @Test
    public void testCreateRole_ThenReturnTrue(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.create(any(Role.class))).thenReturn(true);

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        boolean result = roleService.createRole(new RoleDto());
        assertTrue(result);
    }
    @Test
    public void testCreateRole_ThenReturnError(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);

        Mockito.when(mockitoRoleDao.create(null)).thenThrow(new IllegalArgumentException("object is null"));

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        assertThrows(NullPointerException.class,()->roleService.createRole(null));
    }
    //Tests for get all employess
    @Test
    public void testGetAllRole_ThenReturnTrue(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.all()).thenReturn(new ArrayList<>());

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        List<RoleDto> passportDtos = roleService.getAllPassports();
        assertEquals(passportDtos,new ArrayList<>());
    }

    //Tests for update
    @Test
    public void testUpdateByIdRole_ThenReturnTrue(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.update(new Role(),1)).thenReturn(true);

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);
        assertFalse(roleService.updateRole(new RoleDto(),1));
    }
    @Test
    public void testUpdateByIdRole_ThenReturnError(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.update(new Role(), -2)).thenThrow(new IllegalArgumentException("id is less or equals 0"));

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        assertThrows(IllegalArgumentException.class,()->roleService.updateRole(new RoleDto(),-2));
    }
    @Test
    public void testUpdateByIdRole_ThenReturnNullPointor(){
        RoleDao mockitoRoleDao = Mockito.mock(RoleDao.class);
        Mockito.when(mockitoRoleDao.update(null, 24)).thenThrow(new NullPointerException("id is less or equals 0"));

        RoleService roleService = new RoleServiceImpl(mockitoRoleDao);

        assertThrows(NullPointerException.class,()->roleService.updateRole(null,24));
    }
}
