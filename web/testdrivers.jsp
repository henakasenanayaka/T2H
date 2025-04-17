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
        <%@include file="adheader.jsp"%>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <main>
            <h2>Drivers  locations</h2>
            <%
                List<Map<String, String>> drivers = (List<Map<String, String>>) request.getAttribute("drivers");
                int i =1;
            %>



            <br>
            <br>
            <br>



            <div id="googleMap" style="width:100%;height:500px;"></div>

            <script>
                var marker;
                var map;

                function myMap() {
                    var myCenter = new google.maps.LatLng(7.745950494661322, 80.71601162347505);
                    //map options
                    var mapProp = {
                        center: myCenter,
                        zoom: 8,
                    };
                    //new map
                    map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
                    //addd marker
                    <% for (Map<String, String> driver : drivers) {%>
                            
                    marker<%=i%> = new google.maps.Marker({
                        position: new google.maps.LatLng(<%= driver.get("lat")%>,<%= driver.get("lng")%>), //customer lat lon.
                        draggable: false,
                        map: map,
                        title: '<%= driver.get("did")%>'
                    });
                    <%=i++%>
                    <%}%>
                    

                    google.maps.event.addListener(marker, 'dragend', function (event) {
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