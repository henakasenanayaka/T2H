package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "admindeletetadminservlet", urlPatterns = {"/admindeletetadminservlet"})
public class admindeletetadminservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tid = Integer.parseInt(request.getParameter("msg"));
        
        boolean isSuccess = DBUtil.AdminDeleteTAdmin(tid);
        if(isSuccess){
            response.sendRedirect("adminloginservlet?msg=delok");
        }else{
            response.sendRedirect("adminloginservlet?msg=delnotok");
        }
    }
}
