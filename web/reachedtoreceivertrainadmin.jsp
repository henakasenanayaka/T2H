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
            <h2>Received to the second station. Will be assigned to a Driver</h2>
            <%
                List<Map<String, String>> latlons = (List<Map<String, String>>) request.getAttribute("latlons");
            %>

            <table>
                <% for (Map<String, String> latlon : latlons) {%>
                
                <tr>
                    <td colspan="2"><div id="googleMap" style="width:100%;height:500px;"></div></td>
                </tr>
                
            </table>
            <script>
                var marker;
                var map;

                function myMap() {
                    var myCenter = new google.maps.LatLng(<%= latlon.get("tlat")%>, <%= latlon.get("tlon")%>);
                    //map options
                    var mapProp = {
                        center: myCenter,
                        zoom: 14,
                    };
                    //new map
                    map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
                    //addd marker
//                    marker1 = new google.maps.Marker({
//                        position: new google.maps.LatLng(<%= latlon.get("dlat")%>, <%= latlon.get("dlon")%>), //driver lat lon.
//                        draggable: false,
//                        map: map,
//                        title: 'Driver Location'
//                    });
                    
                    marker2 = new google.maps.Marker({
                        position: new google.maps.LatLng(<%=latlon.get("tlat")%>,<%=latlon.get("tlon")%>), //user lat lon
                        draggable: false,
                        map: map,
                        title: 'Train Station Location'
                    });
                }
            </script>
            
<%}%>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD7ngQlbbaL_qjsvJQp02PFTXc_gO916s8&callback=myMap"></script>
        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>