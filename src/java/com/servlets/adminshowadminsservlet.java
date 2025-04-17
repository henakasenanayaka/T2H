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

@WebServlet(name = "adminshowadminsservlet", urlPatterns = {"/adminshowadminsservlet"})
public class adminshowadminsservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = request.getParameter("msg");

        if ("ok".equals(msg)) {
            List<Map<String, String>> admindets = DBUtil.AdminGetAllAdmins();
            request.setAttribute("admindets", admindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowadmins.jsp?msg=ok");
            rd.forward(request, response);
        } else if ("notok".equals(msg)) {
            List<Map<String, String>> admindets = DBUtil.AdminGetAllAdmins();
            request.setAttribute("admindets", admindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowadmins.jsp?msg=notok");
            rd.forward(request, response);
        }  else if ("added".equals(msg)) {
            List<Map<String, String>> admindets = DBUtil.AdminGetAllAdmins();
            request.setAttribute("admindets", admindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowadmins.jsp?msg=added");
            rd.forward(request, response);
        }else if ("notadded".equals(msg)) {
            List<Map<String, String>> admindets = DBUtil.AdminGetAllAdmins();
            request.setAttribute("admindets", admindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowadmins.jsp?msg=notadded");
            rd.forward(request, response);
        }
            else {
            List<Map<String, String>> admindets = DBUtil.AdminGetAllAdmins();
            request.setAttribute("admindets", admindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowadmins.jsp");
            rd.forward(request, response);
        }
    }
}
