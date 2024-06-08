package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.abs.EmployeeDaoService;
import dao.impl.EmployeeDaoServiceImpl;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
@WebServlet("/get_all")
public class GetAllEmployee extends HttpServlet {
    private static final EmployeeDaoService employeeDaoService = new EmployeeDaoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Employee> employees = employeeDaoService.all();
        String json = new ObjectMapper().writeValueAsString(employees);
        resp.getWriter().write(json);
    }
}
