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

@WebServlet(name = "Orderdettakeservlet", urlPatterns = {"/Orderdettakeservlet"})
public class Orderdettakeservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String weight = request.getParameter("weight");
        String ostatus = "Placed";
        String reclat = request.getParameter("lat");
        String reclng = request.getParameter("lon");
        int cid = (int) session.getAttribute("cid");
        String recname = request.getParameter("recname");
        String recmobile = request.getParameter("recmobile");
        int fromStation = Integer.parseInt(request.getParameter("fromstation"));
        int toStation = Integer.parseInt(request.getParameter("tostation"));


        boolean isSuccess = DBUtil.addorderdet(weight, ostatus, reclat, reclng, cid, recname, recmobile, fromStation, toStation);

        if (isSuccess == true) {
            response.sendRedirect("Orderdettakeservlet2");
        } else {

        }

    }
}
