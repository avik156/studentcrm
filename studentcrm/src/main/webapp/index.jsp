<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
    <h3>Log in......</h3>
    <form action="login" method="post">
        Email:<input type="email" name="email"/>
        Password:<input type="password" name="pwd"/>
        <input type="submit" value="login"/>
    </form>
    
    <%
       if(request.getAttribute("error")!=null){
    	       out.println(request.getAttribute("error"));
       }
    %>

</body>
</html>