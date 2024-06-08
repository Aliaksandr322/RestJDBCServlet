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

@WebServlet("/delete_employee")
public class DeleteEmployeeById extends HttpServlet {
    private static final EmployeeDaoService employeeDaoService = new EmployeeDaoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathParam = req.getParameter("id");
        Boolean result = employeeDaoService.deleteById(Integer.valueOf(pathParam));
        String json = new ObjectMapper().writeValueAsString(result);
        resp.getWriter().write(json);
    }
}
