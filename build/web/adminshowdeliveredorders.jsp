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
                List<Map<String, String>> deliveredorders = (List<Map<String, String>>) request.getAttribute("deliveredorders");
            %>
            
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
                    
                </tr>
                <% for (Map<String, String> deliveredorder : deliveredorders) {%>
                <tr>
                    <td><%= deliveredorder.get("oid")%></td>
                    <td><%= deliveredorder.get("date")%></td>
                    <td><%= deliveredorder.get("time")%></td>
                    <td><%= deliveredorder.get("amount")%>/=</td>
                    <td><%= deliveredorder.get("fname") + " " + deliveredorder.get("lname")%></td>
                    <td><%= deliveredorder.get("fromstation")%></td>
                    <td><%= deliveredorder.get("tostation")%></td>
                    
                </tr>
                <% }%>
            </table>

        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %></%@include>
    </body>
</html>