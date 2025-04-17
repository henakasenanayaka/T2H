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

/**
 *
 * @author gemba
 */
@WebServlet(name = "takenfromtadminservlet", urlPatterns = {"/takenfromtadminservlet"})
public class takenfromtadminservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int cid = (int) session.getAttribute("cid");
        boolean isTrue = DBUtil.Checkifordertakenbyrectadmin(cid);

        if (isTrue) {
            response.sendRedirect("reachedtoreceivertrainadminservlet");
        } else {
            List<Map<String, String>> latlons = DBUtil.takenfromtadminservlet(cid);
            request.setAttribute("latlons", latlons);
            RequestDispatcher rd = request.getRequestDispatcher("takenfromtadmin.jsp");
            rd.forward(request, response);
        }
    }
}
