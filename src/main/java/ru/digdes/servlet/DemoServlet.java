package ru.digdes.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "FirstServlet",
        description = "Example Servlet Using Annotations",
        urlPatterns = {"/first"}
)
public class DemoServlet extends HttpServlet {

    private ServletConfig config;
    @Override
    public void init (ServletConfig config) {
        this.config = config;
    }
    @Override
    public void destroy() {}
    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }
    @Override
    public String getServletInfo()
    {
        return "A Simple Servlet";
    }

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("MyServlet's doGet() method is invoked.");
        doAction(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        System.out.println("MyServlet's doPost() method is invoked.");
        doAction(req, resp);
    }

    private void doAction(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/plain");
        resp.getWriter().write("Hello " + name + "!");
    }
}
