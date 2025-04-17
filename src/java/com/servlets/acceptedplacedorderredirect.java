package com.servlets;

import static com.servlets.acceptedplacedorder.findNearestDriver;
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

@WebServlet(name = "acceptedplacedorderredirect", urlPatterns = {"/acceptedplacedorderredirect"})
public class acceptedplacedorderredirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int cid = (int) session.getAttribute("cid");
        boolean isTrue = DBUtil.Checkifordertakenbyrider(cid);

        if (isTrue) {
            response.sendRedirect("takenfromriderservlet");
        } else {
            List<Map<String, String>> dets = DBUtil.acceptedplacedorder(cid);
            request.setAttribute("dets", dets);
            RequestDispatcher rd = request.getRequestDispatcher("driverfound.jsp");
            rd.forward(request, response);
        }

    }
}
