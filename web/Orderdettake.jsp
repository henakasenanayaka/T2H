<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>T2H By NSBM</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="admin.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            List<Map<String, String>> stations = (List<Map<String, String>>) request.getAttribute("stations");
            int cid = (int)request.getAttribute("cid");
        %>
        <%@include file="header.jsp"%>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
        <main>
            <h2>Details of the parcel</h2>
    <br>

    <form action="Orderdettakeservlet" method="post">
        <table>
            <tr>
                <td>Weight of the package :</td>
                <td><input type="text" name="weight" placeholder="use Kg"></td>
            </tr>
            <tr>
                <td>Receiver Name :</td>
                <td><input type="text" name="recname"></td>
            </tr>
            <tr>
                <td>Receiver Mobile No :</td>
                <td><input type="text" name="recmobile" placeholder="07xxxxxxxx"></td>
            </tr>
            <tr>
                <td>From Station : </td>
                <td>
                    <select name="fromstation">
                        <% for (Map<String, String> station : stations) { %>
                        <option value="<%= station.get("tsid") %>"><%= station.get("station") %></option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>To Station :</td>
                <td>
                    <select name="tostation">
                        <% for (Map<String, String> station : stations) { %>
                        <option value="<%= station.get("tsid") %>"><%= station.get("station") %></option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <h1>Drag to Receiver location</h1>
                    <div id="googleMap" style="width:100%;height:500px;"></div>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="submit" value="Save details"></td>
            </tr>
        </table>
                    <input type="hidden" name="lat" id="lat" value="7.745950494661322">
                    <input type="hidden" name="lon" id="lon" value="80.71601162347505">
                    <input type="hidden" name="cid" value="<%=cid%>">
                    
    </form>
    <script>
                var marker;
                var map;

                function myMap() {
                    var myCenter = new google.maps.LatLng(7.745950494661322,80.71601162347505);

                    var mapProp = {
                        center: myCenter,
                        zoom:8,
                    };

                    map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

                    marker = new google.maps.Marker({
                        position: myCenter,
                        draggable: true,
                        map: map
                    });

                    google.maps.event.addListener(marker, 'dragend', function(event) {
                        document.getElementById('lat').value = event.latLng.lat();
                        document.getElementById('lon').value = event.latLng.lng();
                    });
                }
            </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD7ngQlbbaL_qjsvJQp02PFTXc_gO916s8&callback=myMap"></script>
        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
