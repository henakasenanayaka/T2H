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
            %>
            <h1>Train Admins Details an Modify</h1>
            <form action="admineditadminandsaveservlet" method="post">
                <table style="border: 1px solid black; width: 100%;background-color: #f2f2f2;">
                    <% for (Map<String, String> admindet : admindets) {%>
                    <tr>
                        <th>ID</th>
                        <td><input type="text" value="<%= admindet.get("cid")%>" disabled></td>
                        <td><input type="hidden" name="cid" value="<%= admindet.get("cid")%>"></td>
                    </tr>
                    <tr>
                        <th>First Name</th>
                        <td><input type="text" name="fname" value="<%= admindet.get("fname")%>"></td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><input type="text" name="lname" value="<%= admindet.get("lname")%>"></td>
                    </tr>
                    <tr>
                        <th>NIC</th>
                        <td><input type="text" name="nic" value="<%= admindet.get("nic")%>"></td>
                    </tr>
                    <tr>
                        <th>Mobile</th>
                        <td><input type="text" name="mobile" value="<%= admindet.get("mobile")%>"></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="text" name="email" value="<%= admindet.get("email")%>"></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type="text" name="pwd" value="<%= admindet.get("pwd")%>"></td>
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