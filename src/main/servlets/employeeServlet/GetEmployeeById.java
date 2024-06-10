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

@WebServlet("/get_employee")
public class GetEmployeeById extends HttpServlet {
    private  EmployeeDao employeeDao = new EmployeeDaoImpl();
    private  RoleDao roleDao = new RoleDaoImpl();
    private  EmployeeService employeeService = new EmployeeServiceImpl(employeeDao,roleDao);


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathParam = req.getParameter("id");
        String json = new ObjectMapper().writeValueAsString(employeeService.getEmployeeById(Integer.parseInt(pathParam)));
        resp.getWriter().write(json);
    }
}
