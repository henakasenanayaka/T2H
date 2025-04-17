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
        <form action="registercusservlet" method="post">
            <table>
                <tr>
                    <td>First Name :</td>
                    <td><input type="text" name="fname"></td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><input type="text" name="lname"></td>
                </tr>
                <tr>
                    <td>NIC number :</td>
                    <td><input type="text" name="nic"></td>
                </tr>
                <tr>
                    <td>Mobile Number :</td>
                    <td><input type="text" name="mobile"></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="password" name="pwd"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </main>

    <script src="admin.js"></script>
    <%@include file="footer.jsp"%>
    </body>
</html>
