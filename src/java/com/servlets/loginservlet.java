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
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginservlet", urlPatterns = {"/loginservlet"})
public class loginservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        
        boolean ifTAdminSuccess = DBUtil.TrainAdminLogin(email, pwd);
        boolean isSuccess = DBUtil.login(email, pwd);
        
        
        if(isSuccess == true){
            session.setAttribute("email", email);
            int cid = DBUtil.getid(email);
            session.setAttribute("cid", cid);
            response.sendRedirect("index.jsp?msg=logged");
        }
        else if(ifTAdminSuccess == true){
            session.setAttribute("email", email);
            int tid = DBUtil.getTadminID(email);
            int tsid = DBUtil.gettadmintsid(email);
            System.out.println(tsid);
            session.setAttribute("tsid", tsid);
            session.setAttribute("tid", tid);
            response.sendRedirect("trainadminordertypeselect.jsp");
        }
        else{
            response.sendRedirect("index.jsp?msg=nouser");
        }
    }
}
