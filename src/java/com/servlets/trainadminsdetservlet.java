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

@WebServlet(name = "trainadminsdetservlet", urlPatterns = {"/trainadminsdetservlet"})
public class trainadminsdetservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
        request.setAttribute("tadmindets", tadmindets);
        RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
        rd.forward(request, response);
    }
}
