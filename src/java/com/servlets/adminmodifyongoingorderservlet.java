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

@WebServlet(name = "adminmodifyongoingorderservlet", urlPatterns = {"/adminmodifyongoingorderservlet"})
public class adminmodifyongoingorderservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("msg"));
        
        List<Map<String, String>> ongoingorderdets = DBUtil.AdminGetOngoingOrder(oid);
        List<Map<String, String>> stations = DBUtil.getstations();
        request.setAttribute("ongoingorderdets", ongoingorderdets);
        request.setAttribute("stations", stations);
        RequestDispatcher rd = request.getRequestDispatcher("adminshowsingleongoingorder.jsp");
        rd.forward(request, response);
    }
}
