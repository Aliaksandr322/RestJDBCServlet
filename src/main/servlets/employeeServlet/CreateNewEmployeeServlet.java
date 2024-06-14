package servlets.employeeServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.abs.EmployeeDao;
import dao.abs.RoleDao;
import dao.impl.EmployeeDaoImpl;
import dao.impl.RoleDaoImpl;
import dto.EmployeeDto;
import org.json.JSONObject;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import utils.ConvertToString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create_emp")
public class CreateNewEmployeeServlet extends HttpServlet {
    private static final EmployeeDao employeeDao = new EmployeeDaoImpl();
    private static final RoleDao roleDao = new RoleDaoImpl();
    private static final ConvertToString util = new ConvertToString();
    private static final EmployeeService employeeService = new EmployeeServiceImpl(employeeDao,roleDao);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        EmployeeDto employeeDto = new EmployeeDto();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        String output = util.convertToString(req.getReader());
        final JSONObject jsonObject = employeeDto.doWork(output);
        employeeDto.setName(jsonObject.getString("name"));
        employeeDto.setAddress(jsonObject.getString("address"));
        String result = new ObjectMapper().writeValueAsString(employeeService.createEmployee(employeeDto));
        resp.getWriter().write(result);

    }
}
