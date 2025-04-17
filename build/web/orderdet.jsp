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
            <h2>Order Details</h2>
            <%
                List<Map<String, String>> getorderdet = (List<Map<String, String>>) request.getAttribute("getorderdet");
            %>
            <br>

            <%
                if ("allreadyplaced".equals(msg)) {
            %>
            <h2 style="color: red" align="center">Continue with Saved order First!</h2>
            <%}%>

            <form action="acceptedplacedorder" method="post">
                <table>
                    <tr>
                        <td>Weight of the package :</td>
                        <td><%= getorderdet.get(0).get("weight")%> KG</td>
                    </tr>
                    <tr>
                        <td>Sender Name :</td>
                        <td><%= getorderdet.get(0).get("fname")%> <%= getorderdet.get(0).get("lname")%></td>
                    </tr>
                    <tr>
                        <td>Sender Mobile :</td>
                        <td><%= getorderdet.get(0).get("mobile")%></td>
                    </tr>
                    <tr>
                        <td>Receiver Name :</td>
                        <td><%= getorderdet.get(0).get("recname")%></td>
                    </tr>
                    <tr>
                        <td>Receiver Mobile :</td>
                        <td><%= getorderdet.get(0).get("recmobile")%></td>
                    </tr>
                    <tr>
                        <td>Amount :</td>
                        <td>12300.00</td>
                    </tr>
                    <tr>
                        <td>From Station : </td>
                        <td><%= getorderdet.get(0).get("fromstation")%><input type="hidden" name="fromstation" value="<%= getorderdet.get(0).get("fromstation")%>"></td>
                    </tr>
                    <tr>
                        <td>To Station : </td>
                        <td><%= getorderdet.get(0).get("tostation")%><input type="hidden" name="tostation" value="<%= getorderdet.get(0).get("tostation")%>"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <h3 style="color: red" align="center">Check if the locations are Correct!</h3>
                            <div id="googleMap" style="width:100%;height:500px;"></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="submit" value="Save details"></td>
                    </tr>
                </table>
            </form>
            <button class="btn" style="width:'100'"><a href="deletecurrentorderservlet" style="color:#FFFFFF">Delete Current Order?</a></button>
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
                    marker1 = new google.maps.Marker({
                        position: new google.maps.LatLng(<%= getorderdet.get(0).get("lat")%>,<%= getorderdet.get(0).get("lon")%>), //customer lat lon.
                        draggable: false,
                        map: map,
                        title: 'Your Location'
                    });
                    marker2 = new google.maps.Marker({
                        position: new google.maps.LatLng(<%= getorderdet.get(0).get("reclat")%>,<%= getorderdet.get(0).get("reclon")%>), //rec lat lon
                        draggable: false,
                        map: map,
                        title: 'Receiver Location'
                    });
                    marker3 = new google.maps.Marker({
                        position: new google.maps.LatLng(<%= getorderdet.get(0).get("tolat")%>,<%= getorderdet.get(0).get("tolon")%>), //tostation.
                        draggable: false,
                        map: map,
                        title: 'Station2'
                    });
                    marker4 = new google.maps.Marker({
                        position: new google.maps.LatLng(<%= getorderdet.get(0).get("fromlat")%>,<%= getorderdet.get(0).get("fromlon")%>), //fromlatlon.
                        draggable: false,
                        map: map,
                        title: 'Station1'
                    });

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