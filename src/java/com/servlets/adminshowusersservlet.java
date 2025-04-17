package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminshowusersservlet", urlPatterns = {"/adminshowusersservlet"})
public class adminshowusersservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = request.getParameter("msg");
        if ("ok".equals(msg)) {
            List<Map<String, String>> userdets = DBUtil.AdminGetAllUsers();
            request.setAttribute("userdets", userdets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowusers.jsp?msg=ok");
            rd.forward(request, response);
        } else if ("notok".equals(msg)) {
            List<Map<String, String>> userdets = DBUtil.AdminGetAllUsers();
            request.setAttribute("userdets", userdets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowusers.jsp?msg=notok");
            rd.forward(request, response);
        } else {
            List<Map<String, String>> userdets = DBUtil.AdminGetAllUsers();
            request.setAttribute("userdets", userdets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowusers.jsp");
            rd.forward(request, response);
        }
    }
}
