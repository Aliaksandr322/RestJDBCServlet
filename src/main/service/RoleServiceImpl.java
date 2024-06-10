package service;

import dao.abs.PassportDao;
import dao.abs.RoleDao;
import dto.PassportDto;
import dto.RoleDto;
import model.Employee;
import model.Passport;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    private static RoleDao roleDao;

    public RoleServiceImpl (RoleDao roleDao){
        this.roleDao = roleDao;
    }
    @Override
    public RoleDto getRoleById(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("id is less or equal 0");
        }
        Role role = roleDao.findById(id);
        return toRoleDto(role);
    }

    @Override
    public List<RoleDto> getAllPassports() {
        List<RoleDto> roleDtos = new ArrayList<>();
        List<Role> roles = roleDao.all();
        for(Role r : roles){
            roleDtos.add(toRoleDto(r));
        }
        return roleDtos;
    }

    @Override
    public boolean deleteRoleById(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("id is less or equal 0");
        }
        return roleDao.deleteById(id);
    }

    @Override
    public boolean createRole(RoleDto roleDto) {
        if(roleDto == null){
            throw new NullPointerException("object is null");
        }
        Role role = toRole(roleDto);
        return roleDao.create(role);
    }

    @Override
    public boolean updateRole(RoleDto roleDto, int id) {
        if(roleDto == null){
            throw new NullPointerException("object is null");
        }
        if(id <= 0) throw new IllegalArgumentException("id is less or equals 0");
        Role role = toRole(roleDto);
        return roleDao.update(role,id);
    }

    private static RoleDto toRoleDto(Role role){
        String name = role.getName();
        List<Employee> emplName = new ArrayList<>();
        for(Employee employee : role.getEmployeesSet()){
            emplName.add(employee);
        }
        return new RoleDto(name,emplName);
    }

    private static Role toRole(RoleDto roleDto){
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setEmployeesSet(new ArrayList<>());
        return role;
    }
}
