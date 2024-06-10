package servlets;


import org.junit.jupiter.api.Test;

import servlets.employeeServlet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;


import static org.mockito.Mockito.*;

public class ServletTest {

    @Test
    public void getEmployeeByIdServletTest_ThenReturnTrue() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        GetEmployeeById servlet = new GetEmployeeById();

        when(request.getParameter(any())).thenReturn("6");
        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);


        verify(request, times(1)).getParameter("id");
        verify(response, times(1)).getWriter();
    }

    @Test
    public void getAllEmployeeServletTest_ThenReturnTrue() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        GetAllEmployee servlet = new GetAllEmployee();

        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        verify(response, times(1)).getWriter();
    }

    @Test
    public void deleteEmployeeByIdServletTest_ThenReturnTrue() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        DeleteEmployeeById servlet = new DeleteEmployeeById();

        when(request.getParameter(any())).thenReturn("5");
        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);


        verify(request, times(1)).getParameter("id");
        verify(response, times(1)).getWriter();
    }

    @Test
    public void createEmployeeByIdServletTest_ThenReturnTrue() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        String json = "{\"name\":Alex, \"address\":qwe}";
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        CreateNewEmployeeServlet servlet = new CreateNewEmployeeServlet();
        when(request.getReader()).thenReturn(
                new BufferedReader(new StringReader(json)));
        when(response.getWriter()).thenReturn(writer);
        servlet.doPost(request, response);

        verify(response).setCharacterEncoding("UTF-8");
        verify(request).setCharacterEncoding("UTF-8");
        verify(response, times(1)).getWriter();
    }

    @Test
    public void updateEmployeeByIdServletTest_ThenReturnTrue() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        String json = "{\"name\":Alex, \"address\":Nezavisimosti 43}";
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        UpdateEmployeeServlet servlet = new UpdateEmployeeServlet();
        when(request.getReader()).thenReturn(
                new BufferedReader(new StringReader(json)));
        when(response.getWriter()).thenReturn(writer);
        when(request.getParameter(any())).thenReturn("25");
        servlet.doPost(request, response);

        verify(response).setCharacterEncoding("UTF-8");
        verify(request).setCharacterEncoding("UTF-8");
        verify(response, times(1)).getWriter();
    }
}
