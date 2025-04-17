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
                List<Map<String, String>> tadminsdets = (List<Map<String, String>>) request.getAttribute("tadmindets");
                if ("ok".equals(msg)) {
            %>
            <h3 style="color:red">Train admin Successfully Updated!</h3>
            <%}%><%
                if ("notok".equals(msg)) {
            %>
            <h3 style="color:red">Error! Update Unsuccessfull!</h3>
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
            <%
                if ("added".equals(msg)) {
            %>
            <h3 style="color:red">Train Admin Registered!</h3>
            <%}%>
            <%
                if ("notadded".equals(msg)) {
            %>
            <h3 style="color:red">Error! Registration Unsuccessful!</h3>
            <%}%>
            <h1>Train Admins Details an Modify</h1><h3>Add An Admin Here <a href="adminaddtadminregservlet">(+)</a></h3>

            <table style="border: 1px solid black; width: 100%;background-color: #f2f2f2;">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>NIC</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Station</th>
                    <th>Modify / Delete</th>
                </tr>
                <% for (Map<String, String> tadminsdet : tadminsdets) {%>
                <tr>
                    <td><%= tadminsdet.get("tid")%></td>
                    <td><%= tadminsdet.get("fname") + " " + tadminsdet.get("lname")%></td>
                    <td><%= tadminsdet.get("nic")%></td>
                    <td><%= tadminsdet.get("mobile")%></td>
                    <td><%= tadminsdet.get("email")%></td>
                    <td><%= tadminsdet.get("pwd")%></td>
                    <td><%= tadminsdet.get("station")%></td>
                    <td><button class="box"><a href="adminmodifytadminservlet?msg=<%= tadminsdet.get("tid")%>">Modify</a></button><button class="box"><a href="admindeletetadminservlet?msg=<%= tadminsdet.get("tid")%>">Delete</a></button></td>
                </tr>
                <% }%>
            </table>

        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %></%@include>
    </body>
</html>