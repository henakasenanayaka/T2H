    <header class="header">
        <img src="logo.jpeg" width="50" height="50" alt="Logo" class="logo"> <i class="fas fa-shopping-basket"></i> 


        <nav class="navbar">
            <a href="index.jsp">Home</a>
            <a href="Orderdettakeservlet2">Current_Order</a>
             <a href="loginservlet2">Send_Parcel_now</a>
             <a href="acceptedplacedorderredirect">Track Current Order </a><!--
             <a href="#home">Train admin </a>
            <a href="#features">Tracking service</a>-->
            <a href="#features">Messages</a>
            
        </nav>


        <div class="icons">
            <div class="fa fa-bars" id="menu-btn"></div>
            <div class="fa fa-search" id="search-btn"></div>
            
            <div class="fa fa-user" id="login-btn"></div>
        </div>


        <form class="search-form">
            <input type="search" id="search-box" placeholder="Search Here...">
            <label for="search-box" class="fa fa-search"></label>
        </form>

        <form action="loginservlet" method="post" class="login-form">
            
            <%
                String msg = request.getParameter("msg");
                String email = (String)session.getAttribute("email");
                    
                if("nouser".equals(msg)){
            %>
            <h1>No User! Try again!</h1>
            <%
                }
                if(email != null){%>
                <%
                    if("logged".equals(msg)){
                %>
                <h4>Logged in Successfully!!!</h4>
                <%}%>
                <h1>Welcome!</h1>
                <h1><%=email%></h1>
                <a href="logoutservlet">Log Out!</a>
                <%}else{%>
                <h3>Login Now</h3>
            <input type="email" placeholder="Your email" class="box" name="email">
            <input type="password" placeholder="Your password" class="box" name="pwd">

            <p>Forget Your Password <a href="#"> Click Here </a></p>
            <p>Don't Have An Account <a href="register.jsp"> Create Now </a></p>
            <br>
            <p>Are you an Admin? <a href="adminlogin.jsp">Click here</a></p>

            <input type="submit" value="Login Now" class="btn">
            <%}%>
        </form>

    </header>