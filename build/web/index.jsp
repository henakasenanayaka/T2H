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
    <main style="background-image: url('1.jpg.png'); background-size: cover; background-position: center;">
        <%
            if("logged".equals(msg)){
        %>
        
            <h4 style="color: red">Logged in Successfully!!!</h4>
        <%}%>
        
        <%
            if("nouser".equals(msg)){
        %>
        
            <h1>No User! Try again!</h1>
            
        <%}%>
        <%
            if("logout".equals(msg)){
        %>
        
            <h4 style="color: red">Logged OUT Successfully!!!</h4>
        <%}%>
        <%
            if("reg".equals(msg)){
        %>
        
            <h4 style="color: red">Registration Successful!!!</h4>
        <%}%>
        <%
            if("error".equals(msg)){
        %>
        
            <h4 style="color: red">Error Occurred!!!</h4>
        <%}%>
        <%
            if("curdeleted".equals(msg)){
        %>
        
            <h4 style="color: red">Order Deleted Successfully!</h4>
        <%}%>
        <section>
            <h1 align="center">Welcome to Train to Home Delivery Courier Service!</h1>
        </section>

        <section>
            <h2>How It Works</h2>
            <ol>
                <li>Enter Your Tracking ID: Simply enter your unique tracking ID into our user-friendly interface.</li>
                <li>Instant Status Update: Receive instant updates on the current status of your delivery, including location and estimated delivery time.</li>
                <li>Live Map Tracking: Visualize the real-time location of your package on our interactive map.</li>
            </ol>
        </section>

        <section>
            <h2>Secure and Confidential</h2>
            <p>Rest assured, your privacy and security are our top priorities. Our platform employs the latest encryption technologies to ensure that your tracking information is kept confidential and secure.</p>
        </section>

        <section>
            <h2>Mobile-Friendly</h2>
            <p>Track your deliveries on the go! Our website is fully responsive, making it easy for you to access our services from your smartphone or tablet.</p>
        </section>

        <section>
            <h2>Why Choose Train to Home Delivery Querier Service?</h2>
            <ul>
                <li>Reliability: We work with trusted delivery partners to provide you with accurate and timely information.</li>
                <li>User-Friendly: Our interface is designed with you in mind, making it easy for anyone to track their deliveries.</li>
                <li>Customer Support: Have questions or concerns? Our dedicated customer support team is here to assist you.</li>
            </ul>
        </section>

        <section>
            <h2>Get Started Today!</h2>
            <p>Don't let uncertainty ruin your delivery experience. Experience the peace of mind that comes with knowing exactly where your package is at all times. Enter your tracking ID now and let Train to Home Delivery Querier Service take care of the rest!</p>
            <button onclick="getStarted()">Get Started</button>
        </section>

        <section>
            <p>Thank you for choosing Train to Home – Where Tracking Meets Peace of Mind.</p>
        </section>  
    </main>

    <script src="admin.js"></script>
        <%@include file="footer.jsp"%>
    </body>
</html>
