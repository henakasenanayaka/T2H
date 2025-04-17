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
        <h1 align="center">Admin Login Page</h1>
        <br>
        <br>
        <form action="adminloginservlet" method="post">
            <table>
                <tr>
                    <th><label for="email">Email</label></th>
                    <td><input type="text" name="email" class="box"></td>
                </tr>
                <tr>
                    <th><label for="pwd">Password</label></th>
                    <td><input type="password" name="pwd" class="box"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </main>
    <script src="admin.js"></script>
    <%@include file="footer.jsp" %>
</body>


