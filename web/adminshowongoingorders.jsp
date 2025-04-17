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
                List<Map<String, String>> ongoingordersdets = (List<Map<String, String>>) request.getAttribute("ongoingordersdets");
                if ("ok".equals(msg)) {
            %>
            <h3 style="color:red">Train admin Successfully Updated!</h3>
            <%}%><%
                if ("notok".equals(msg)) {
            %>
            <h3 style="color:red">Error! Update Unsuccessful!</h3>
            <%}%>
            <%
                if ("delok".equals(msg)) {
            %>
            <h3 style="color:red">Deleted Successfully!</h3>
            <%}%>
            <%
                if ("delnotok".equals(msg)) {
            %>
            <h3 style="color:red">Error! Delete Unsuccessful!</h3>
            <%}%>
            <h1>Ongoing Orders</h1>

            <table style="border: 1px solid black; width: 100%;background-color: #f2f2f2;">
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Amount</th>
                    <th>Name</th>
                    <th>From Station</th>
                    <th>To Station</th>
                    <th>Modify / Delete</th>
                </tr>
                <% for (Map<String, String> ongoingorderdets : ongoingordersdets) {%>
                <tr>
                    <td><%= ongoingorderdets.get("oid")%></td>
                    <td><%= ongoingorderdets.get("date")%></td>
                    <td><%= ongoingorderdets.get("time")%></td>
                    <td><%= ongoingorderdets.get("amount")%>/=</td>
                    <td><%= ongoingorderdets.get("fname") + " " + ongoingorderdets.get("lname")%></td>
                    <td><%= ongoingorderdets.get("fromstation")%></td>
                    <td><%= ongoingorderdets.get("tostation")%></td>
                    <td><button class="box"><a href="adminmodifyongoingorderservlet?msg=<%= ongoingorderdets.get("oid")%>">See More / Modify</a></button><button class="box"><a href="admindeletetadminservlet?msg=<%= ongoingorderdets.get("oid")%>">Delete</a></button></td>
                </tr>
                <% }%>
            </table>

        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %></%@include>
    </body>
</html>