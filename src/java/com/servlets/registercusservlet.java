package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registercusservlet", urlPatterns = {"/registercusservlet"})
public class registercusservlet extends HttpServlet {

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
        
        boolean isSuccess = DBUtil.register(fname, lname, nic, mobile, email, pwd);
        if(isSuccess == true){
            response.sendRedirect("index.jsp?msg=reg");
        }else{
            response.sendRedirect("index.jsp?msg=error");
        }
    }
}
