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

@WebServlet(name = "pickupservlet", urlPatterns = {"/pickupservlet"})
public class pickupservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        int cid = (int)session.getAttribute("cid");
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        
        
        boolean isSuccess = DBUtil.updateLatLon(email, lat, lon);
        if(isSuccess == true){
            List<Map<String, String>> stations = DBUtil.getstations();
            request.setAttribute("cid", cid);
            request.setAttribute("stations", stations);
            RequestDispatcher rd = request.getRequestDispatcher("Orderdettake.jsp");
            rd.forward(request, response);
        }else {
            response.sendRedirect("error.jsp");
        }
        
        //send to order det page
    }
}
