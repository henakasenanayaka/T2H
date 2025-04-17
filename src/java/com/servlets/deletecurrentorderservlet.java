package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "deletecurrentorderservlet", urlPatterns = {"/deletecurrentorderservlet"})
public class deletecurrentorderservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int cid = (int) session.getAttribute("cid");

        boolean isSuccess = DBUtil.DelPlacedOrder(cid);
        if (isSuccess == true) {
            response.sendRedirect("index.jsp?msg=curdeleted");
        } else {
            response.sendRedirect("index.jsp?msg=error");
        }
    }
}
