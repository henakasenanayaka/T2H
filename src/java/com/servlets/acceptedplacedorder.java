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

@WebServlet(name = "acceptedplacedorder", urlPatterns = {"/acceptedplacedorder"})
public class acceptedplacedorder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int cid = (int) session.getAttribute("cid");
        boolean isSuccess = DBUtil.updateplacedorder(cid);

        if (isSuccess) {
            List<Map<String, String>> drivers = DBUtil.getnotbusydriverlatlngs();
            String email = (String) session.getAttribute("email");
            List<Map<String, String>> cuslatlon = DBUtil.getLanLon(email);
            double cuslat = Double.parseDouble(cuslatlon.get(0).get("lat"));
            double cuslng = Double.parseDouble(cuslatlon.get(0).get("lon"));
            int neardriver = Integer.parseInt(findNearestDriver(drivers, cuslat, cuslng));
//            List<Map<String, String>> driverdets = DBUtil.getdriverdets(neardriver);
            int oid = DBUtil.customerongoingorderid(cid);
            DBUtil.orderdriver(oid, neardriver);
            DBUtil.driverbusystatus(neardriver);
            String fromstation = request.getParameter("fromstation");
            String tostation = request.getParameter("tostation");
            int fromstationid = DBUtil.getStationID(fromstation);
            int tostationid = DBUtil.getStationID(tostation);
            DBUtil.inserttoorderstationfrom(oid, fromstationid);
            DBUtil.inserttoorderstationto(oid, tostationid);
            
            
//            request.setAttribute("cuslatlon", cuslatlon);
//            request.setAttribute("driverdets", driverdets);
//            RequestDispatcher rd = request.getRequestDispatcher("driverfound.jsp");
//            rd.forward(request, response);
            response.sendRedirect("acceptedplacedorderredirect");

        } else {
            
        }
    }

    public static String findNearestDriver(List<Map<String, String>> drivers, double customerLat, double customerLon) {
        double minDistance = Double.MAX_VALUE;
        Map<String, String> nearestDriver = null;

        for (Map<String, String> driver : drivers) {
            double driverLat = Double.parseDouble(driver.get("lat"));
            double driverLon = Double.parseDouble(driver.get("lng"));
            double distance = distance(customerLat, customerLon, driverLat, driverLon);
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }

        if (nearestDriver != null) {
            return nearestDriver.get("did");
        } else {
            return null;
        }
    }

    private static final int EARTH_RADIUS = 6371;

    private static double toRadians(double degrees) {
        return degrees * Math.PI / 180.0;
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = toRadians(lat2 - lat1);
        double dLon = toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
