<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>T2H By NSBM</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="admin.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="adheader.jsp"%></%@include>
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
                List<Map<String, String>> ongoingorderdets = (List<Map<String, String>>) request.getAttribute("ongoingorderdets");
                List<Map<String, String>> stations = (List<Map<String, String>>) request.getAttribute("stations");
            %>
            <h1>Edit Ongoing Order</h1>
            <form action="adminsaveeditedorderservlet" method="post">
                <table style="border: 1px solid black; width: 100%;background-color: #f2f2f2;">
                    <% for (Map<String, String> ongoingorderdet : ongoingorderdets) {%>
                    <tr>
                        <th>Order ID</th>
                        <td><input type="text" value="<%= ongoingorderdet.get("oid")%>" disabled></td>
                        <td><input type="hidden" name="oid" value="<%= ongoingorderdet.get("oid")%>"></td>
                    </tr>
                    <tr>
                        <th>Customer ID</th>
                        <td><input type="text" value="<%= ongoingorderdet.get("cid")%>" disabled><input type="hidden" name="cid" value="<%= ongoingorderdet.get("cid")%>"></td>
                    </tr>
                    <tr>
                        <th>Order Status</th>
                        <td>
                            <input type="text" value="<%= ongoingorderdet.get("ostatus")%>" disabled>
                            <select name="ostatus">
                                <option value="Ongoing">Ongoing</option>
                                <option value="Taken From Rider">Taken From Rider</option>
                                <option value="Taken From Trainadmin">Taken From Trainadmin</option>
                                <option value="Reached to Receiver TrainAdmin">Reached to Receiver TrainAdmin</option>
                                <option value="Out for Delivery">Out for Delivery</option>
                                <option value="Cancel">Cancel</option>
                                <option value="Delivered">Delivered</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>First Name</th>
                        <td><input type="text" name="fname" value="<%= ongoingorderdet.get("fname")%>" disabled></td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><input type="text" name="lname" value="<%= ongoingorderdet.get("lname")%>" disabled></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="text" name="email" value="<%= ongoingorderdet.get("email")%>" disabled></td>
                    </tr>
                    <tr>
                        <th>Latitude</th>
                        <td><input type="text" name="lat" value="<%= ongoingorderdet.get("lat")%>" ></td>
                    </tr>
                    <tr>
                        <th>Longitude</th>
                        <td><input type="text" name="lon" value="<%= ongoingorderdet.get("lon")%>"></td>
                    </tr>
                    <tr>
                        <th>Weight</th>
                        <td><input type="text" name="weight" value="<%= ongoingorderdet.get("weight")%>"></td>
                    </tr>
                    <tr>
                        <th>Date</th>
                        <td><input type="text" name="date" value="<%= ongoingorderdet.get("date")%>"></td>
                    </tr>
                    <tr>
                        <th>Time</th>
                        <td><input type="text" name="time" value="<%= ongoingorderdet.get("time")%>"></td>
                    </tr>
                    <tr>
                        <th>Amount</th>
                        <td><input type="text" name="amount" value="<%= ongoingorderdet.get("amount")%>"></td>
                    </tr>
                    <tr>
                        <th>Receiver Latitude</th>
                        <td><input type="text" name="reclat" value="<%= ongoingorderdet.get("reclat")%>"></td>
                    </tr>
                    <tr>
                        <th>Receiver Longitude</th>
                        <td><input type="text" name="reclon" value="<%= ongoingorderdet.get("reclon")%>"></td>
                    </tr>
                    <tr>
                        <th>Receiver name</th>
                        <td><input type="text" name="recname" value="<%= ongoingorderdet.get("recname")%>"></td>
                    </tr>
                    <tr>
                        <th>Receiver Mobile</th>
                        <td><input type="text" name="recmobile" value="<%= ongoingorderdet.get("recmobile")%>"></td>
                    </tr>
                    <tr>
                        <th>From Station</th>
                        <td>
                            <input type="text" value="<%= ongoingorderdet.get("fromstation")%>" disabled>
                            <select name="fromstationid">
                                <% for (Map<String, String> station : stations) {%>
                                <option value="<%= station.get("tsid")%>"><%= station.get("station")%></option>
                                <% }%>
                            </select><br><br>
                        </td>
                    </tr>
                    <tr>
                        <th>To Station</th>
                        <td>
                            
                            <input type="text" name="pwd" value="<%= ongoingorderdet.get("tostation")%>" disabled>
                            <select name="tostationid">
                                <% for (Map<String, String> station : stations) {%>
                                <option value="<%= station.get("tsid")%>"><%= station.get("station")%></option>
                                <% }%>
                            </select>
                        </td>
                    </tr>
                    <% }%>

                </table>
                <input type="submit" name="submit">
            </form>
        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %></%@include>
    </body>
</html>