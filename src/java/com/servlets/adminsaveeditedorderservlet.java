package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminsaveeditedorderservlet", urlPatterns = {"/adminsaveeditedorderservlet"})
public class adminsaveeditedorderservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        String weight = request.getParameter("weight");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String amount = request.getParameter("amount");
        String reclat = request.getParameter("reclat");
        String reclon = request.getParameter("reclon");
        String recname =request.getParameter("recname");
        String recmobile =request.getParameter("recmobile");
        int fromstationid = Integer.parseInt(request.getParameter("fromstationid"));
        int tostationid = Integer.parseInt(request.getParameter("tostationid"));
        String ostatus = request.getParameter("ostatus");
        
        boolean isSuccess = DBUtil.AdminEditOngoingOrder(oid, cid, weight, date, time, amount, reclat, reclon, recname, recmobile,ostatus, tostationid, fromstationid);
        
        if(isSuccess){
            response.sendRedirect("adminshowongoingordersservlet?msg=ok");
        }else{
            response.sendRedirect("adminshowongoingordersservlet?msg=notok");
        }
    }
}
