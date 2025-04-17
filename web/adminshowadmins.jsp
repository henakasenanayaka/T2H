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
                List<Map<String, String>> admindets = (List<Map<String, String>>) request.getAttribute("admindets");
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
            <h3 style="color:red">Admin added Successfully!</h3>
            <%}%>
            <%
                if ("notadded".equals(msg)) {
            %>
            <h3 style="color:red">Error! Admin register Unsuccessful!</h3>
            <%}%>
            <h1>Admins Details and Modify</h1><h3>Add An Admin Here <a href="adminaddadmin.jsp">(+)</a></h3>

            <table style="border: 1px solid black; width: 100%;background-color: #f2f2f2;">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>NIC</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Modify / Delete</th>
                </tr>
                <% for (Map<String, String> admindet : admindets) {%>
                <tr>
                    <td><%= admindet.get("cid")%></td>
                    <td><%= admindet.get("fname") + " " + admindet.get("lname")%></td>
                    <td><%= admindet.get("nic")%></td>
                    <td><%= admindet.get("mobile")%></td>
                    <td><%= admindet.get("email")%></td>
                    <td><%= admindet.get("pwd")%></td>
                    <td><button class="box"><a href="adminmodifyadminservlet?msg=<%= admindet.get("cid")%>">Modify</a></button><button class="box"><a href="admindeletetadminservlet?msg=<%= admindet.get("cid")%>">Delete</a></button></td>
                </tr>
                <% }%>
            </table>

        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %></%@include>
    </body>
</html>