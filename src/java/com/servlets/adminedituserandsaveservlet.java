package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminedituserandsave", urlPatterns = {"/adminedituserandsave"})
public class adminedituserandsaveservlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String nic = request.getParameter("nic");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        
        boolean isSuccess = DBUtil.AdminUpdateUser(cid, fname, lname, nic, mobile, email, pwd);
        
        if(isSuccess){
            response.sendRedirect("adminshowusersservlet?msg=ok");
            System.out.println("ok");
        }else{
            response.sendRedirect("adminshowusersservlet?msg=notok");
        }
    }
}
