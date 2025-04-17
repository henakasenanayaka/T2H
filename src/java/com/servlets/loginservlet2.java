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

@WebServlet(name = "loginservlet2", urlPatterns = {"/loginservlet2"})
public class loginservlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        int cid = (int) session.getAttribute("cid");

        boolean isPlaced = DBUtil.CheckPlacedOrder(cid);
        boolean isOngoing = DBUtil.Checkiforderistrackable(cid);
        
        if (isOngoing) {
            response.sendRedirect("acceptedplacedorderredirect");
        }else{
        
        if (isPlaced == true) {
            response.sendRedirect("Orderdettakeservlet2?msg=allreadyplaced");
        } else {
            if (email != null) {
                String fname = DBUtil.getName(email);
                List<Map<String, String>> LatLon = DBUtil.getLanLon(email);
                request.setAttribute("LatLon", LatLon);
                request.setAttribute("fname", fname);
                RequestDispatcher rd = request.getRequestDispatcher("urlocation.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("index.jsp?msg=nouser");
            }
        }}

    }
}
