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

@WebServlet(name = "adminloginservlet", urlPatterns = {"/adminloginservlet"})
public class adminloginservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String msg = request.getParameter("msg");

        boolean isSuccess = DBUtil.AdminLogin(email, pwd);

        if (isSuccess) {
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp");
            rd.forward(request, response);
        }else if("ok".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp?mgs=ok");
            rd.forward(request, response);
        }else if("notok".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp?msg=notok");
            rd.forward(request, response);
        }
        else if("delok".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp?msg=delok");
            rd.forward(request, response);
        }else if("delnotok".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp?msg=delnotok");
            rd.forward(request, response);
        }else if("1".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp");
            rd.forward(request, response);
        }else if("added".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp?msg=added");
            rd.forward(request, response);
        }else if("notadded".equals(msg)){
            List<Map<String, String>> tadmindets = DBUtil.getTadminDet();
            request.setAttribute("tadmindets", tadmindets);
            RequestDispatcher rd = request.getRequestDispatcher("adminshowtadmins.jsp?msg=notadded");
            rd.forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
