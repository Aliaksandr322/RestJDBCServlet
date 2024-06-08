package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.abs.OfficeDaoService;
import dao.impl.OfficeDaoServiceImpl;
import model.Office;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get_office")
public class GetOfficeById extends HttpServlet {
    private static final OfficeDaoService officeDaoService = new OfficeDaoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathParam = req.getParameter("id");
        Office employee = officeDaoService.findById(Integer.valueOf(pathParam));
        String json = new ObjectMapper().writeValueAsString(employee);
        resp.getWriter().write(json);
    }
}
