package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.abs.EmployeeDaoService;
import dao.impl.EmployeeDaoServiceImpl;
import dto.Mapper;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get_employee")
public class GetEmployeeById extends HttpServlet {

    private static final EmployeeDaoService employeeDaoService = new EmployeeDaoServiceImpl();
    private static final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathParam = req.getParameter("id");
        Employee employee = employeeDaoService.findById(Integer.valueOf(pathParam));
        String json = new ObjectMapper().writeValueAsString(mapper.toEmployeeDto(employee));
        resp.getWriter().write(json);
    }
}
