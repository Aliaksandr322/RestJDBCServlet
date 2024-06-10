package servlets.employeeServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.abs.EmployeeDao;
import dao.abs.RoleDao;
import dao.impl.EmployeeDaoImpl;
import dao.impl.RoleDaoImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get_all")
public class GetAllEmployee extends HttpServlet {
    private static final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private static final RoleDao roleDao = new RoleDaoImpl();
    private static final EmployeeService employeeService = new EmployeeServiceImpl(employeeDao,roleDao);


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = new ObjectMapper().writeValueAsString(employeeService.getAllEmployee());
        resp.getWriter().write(json);
    }
}
