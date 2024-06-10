package service;

import dto.PassportDto;
import dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getRoleById(int id);
    List<RoleDto> getAllPassports();
    boolean deleteRoleById(int id);
    boolean createRole(RoleDto roleDto);
    boolean updateRole(RoleDto roleDto, int id);
}
