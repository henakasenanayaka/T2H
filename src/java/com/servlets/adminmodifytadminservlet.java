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

@WebServlet(name = "adminmodifytadminservlet", urlPatterns = {"/adminmodifytadminservlet"})
public class adminmodifytadminservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("msg"));
        List<Map<String, String>> tadmindet = DBUtil.AdminEditTAdmin(id);
        List<Map<String, String>> stations = DBUtil.getstations();
        request.setAttribute("tadmindet", tadmindet);
        request.setAttribute("stations", stations);
        RequestDispatcher rd = request.getRequestDispatcher("adminedittadmin.jsp");
        rd.forward(request, response);
    }
}
