package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminedittadminandsaveservlet", urlPatterns = {"/adminedittadminandsaveservlet"})
public class adminedittadminandsaveservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tid = Integer.parseInt(request.getParameter("tid"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String nic = request.getParameter("nic");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String station = request.getParameter("station");
        
        int tsid = DBUtil.getStationID(station);
        
        //tsid cannot be updated check it later
        
        boolean isSuccess = DBUtil.AdminUpdateTAdmin(tid, fname, lname, nic, mobile, email, pwd);
        
        if(isSuccess){
            response.sendRedirect("adminloginservlet?msg=ok");
        }else{
            response.sendRedirect("adminloginservlet?msg=notok");
        }
    }
}
