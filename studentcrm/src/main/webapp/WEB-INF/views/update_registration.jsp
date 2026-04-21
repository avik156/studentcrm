<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
    <h3>Update here.....</h3>
    <form action="updateReg" method="post">
      <pre>
          Email:<input type="email" name="email" value="<%=request.getAttribute("email")%>"/>
          Mobile No:<input type="number" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
          <input type="submit" value="update"/>
      </pre>
    </form>
    
   <%
       if(request.getAttribute("msg")!=null){
    	       out.println(request.getAttribute("msg"));
       }
    %>
</body>
</html>