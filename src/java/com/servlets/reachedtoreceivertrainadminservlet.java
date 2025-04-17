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

@WebServlet(name = "reachedtoreceivertrainadminservlet", urlPatterns = {"/reachedtoreceivertrainadminservlet"})
public class reachedtoreceivertrainadminservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int cid = (int) session.getAttribute("cid");
        boolean isTrue = DBUtil.Checkifordertakenbydeliveryguy(cid);
        
        if(isTrue){
            
        }else{
            List<Map<String, String>> latlons = DBUtil.takenfromrectadminservlet(cid);
        request.setAttribute("latlons",latlons);
        RequestDispatcher rd = request.getRequestDispatcher("reachedtoreceivertrainadmin.jsp");
        rd.forward(request, response);
        }
        
    }
}
