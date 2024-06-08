package model;

public class EmpRole {
    private int EmpId;
    private int RoleId;

    public EmpRole(int empId, int roleId) {
        EmpId = empId;
        RoleId = roleId;
    }

    public EmpRole() {
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }
}
