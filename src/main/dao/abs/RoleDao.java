package dao.abs;

import model.Role;

import java.util.List;

public interface RoleDao extends AbstractDao<Role, Integer>{

    List<Role>findAllRolesByName(List<String> roleNames);
}
