package servlets;

import dao.abs.EmployeeDaoService;
import dao.impl.EmployeeDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create_emp")
public class CreateNewEmployeeServlet extends HttpServlet {
    private static final EmployeeDaoService employeeDaoService = new EmployeeDaoServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
