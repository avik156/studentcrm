<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
    <h3>Register here.....</h3>
    <form action="registration" method="post">
      <pre>
          Name:<input type="text" name="name"/>
          Email:<input type="email" name="email"/>
          Mobile No:<input type="number" name="mob"/>
          <input type="submit" value="save"/>
      </pre>
    </form>
    
    <%
       if(request.getAttribute("msg")!=null){
    	       out.println(request.getAttribute("msg"));
       }
    %>
</body>
</html>