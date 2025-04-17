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

@WebServlet(name = "Orderdettakeservlet2", urlPatterns = {"/Orderdettakeservlet2"})
public class Orderdettakeservlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int cid = (int) session.getAttribute("cid");
        boolean isPlaced = DBUtil.CheckPlacedOrder(cid);
        boolean isOngoing = DBUtil.Checkiforderistrackable(cid);

        if (isOngoing) {
            response.sendRedirect("acceptedplacedorderredirect");
        } else {
            if (isPlaced) {
                List<Map<String, String>> getorderdet = DBUtil.getorderdet(cid);
                request.setAttribute("getorderdet", getorderdet);
                RequestDispatcher rd = request.getRequestDispatcher("orderdet.jsp");
                rd.forward(request, response);

            } else {
                response.sendRedirect("loginservlet2?msg=nocur");
            }
        }

    }

}
