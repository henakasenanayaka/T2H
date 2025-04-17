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
<%
    String fname = request.getAttribute("fname").toString();
    List<Map<String, String>> LatLon =(List<Map<String, String>>) request.getAttribute("LatLon");
%>


<h1>Welcome <%=fname%></h1>
<h2>Drag the Marker to the pickup point</h2>

<div id="googleMap" style="width:100%;height:400px;"></div>

<form action="pickupservlet" method="post">
    <input type="hidden" name="lat" id="lat" value="<%=LatLon.get(0).get("lat")%>">
    <input type="hidden" name="lon" id="lon" value="<%=LatLon.get(0).get("lon")%>">
    <input type="submit" value="Submit" class="btn">
</form>

<script>
    var marker;
    var map;

    function myMap() {
        var myCenter = new google.maps.LatLng(<%=LatLon.get(0).get("lat")%>,<%=LatLon.get(0).get("lon")%>);

        var mapProp = {
            center: myCenter,
            zoom: 17,
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
        <%@include file="footer.jsp"%>
</body>
</html>

