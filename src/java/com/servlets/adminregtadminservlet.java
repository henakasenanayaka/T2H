package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminregtadminservlet", urlPatterns = {"/adminregtadminservlet"})
public class adminregtadminservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String nic = request.getParameter("nic");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        int tsid = Integer.parseInt(request.getParameter("stationid"));
        
        boolean isSuccess = DBUtil.AdminRegTAdmin(fname, lname, nic, mobile, email, pwd, tsid);
        
        if(isSuccess){
            response.sendRedirect("adminloginservlet?msg=added");
        }else{
            response.sendRedirect("adminloginservlet?msg=notadded");
        }
    }
}
