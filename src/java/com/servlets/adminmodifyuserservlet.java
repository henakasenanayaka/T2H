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

@WebServlet(name = "adminmodifyuserservlet", urlPatterns = {"/adminmodifyuserservlet"})
public class adminmodifyuserservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("msg"));
        
        List<Map<String, String>> edituserdets = DBUtil.AdminEditUser(cid);
        
        request.setAttribute("edituserdets", edituserdets);
        RequestDispatcher rd = request.getRequestDispatcher("adminedituser.jsp");
        rd.forward(request, response);
    }
}
