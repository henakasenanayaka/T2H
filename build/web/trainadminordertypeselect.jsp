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
        <%@include file="adheader.jsp"%>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <main>
            <h1>Select A Type</h1>
            <a href=""><button class="box">Taking Orders From Driver</button></a>
        <br>
        <br>
        <a href=""><button class="box">Sending Orders To The Receiver</button></a>
        <br>
        <br>
        <a href=""><button class="box">Past Taken Orders</button></a>
        <br>
        <br>
        <a href=""><button class="box">Past Send Orders</button></a>
        <br>
        <br>
            <table>
            </table>

        </main>
        <script src="admin.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>