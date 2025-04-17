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
                List<Map<String, String>> userdets = (List<Map<String, String>>) request.getAttribute("userdets");
                if ("ok".equals(msg)) {
            %>
            <h3 style="color:red">User Successfully Updated!</h3>
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
            <h1>Users Details an Modify</h1>

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
                <% for (Map<String, String> userdet : userdets) {%>
                <tr>
                    <td><%= userdet.get("cid")%></td>
                    <td><%= userdet.get("fname") + " " + userdet.get("lname")%></td>
                    <td><%= userdet.get("nic")%></td>
                    <td><%= userdet.get("mobile")%></td>
                    <td><%= userdet.get("email")%></td>
                    <td><%= userdet.get("pwd")%></td>
                    <td><button class="box"><a href="adminmodifyuserservlet?msg=<%= userdet.get("cid")%>">Modify</a></button><button class="box"><a href="admindeletetadminservlet?msg=<%= userdet.get("tid")%>">Delete</a></button></td>
                </tr>
                <% }%>
            </table>

        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %></%@include>
    </body>
</html>