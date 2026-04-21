<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>All Students</h2>
    <table border="1">
      <tr>
         <th>Name</th>
         <th>Email</th>
         <th>Mobile</th>
         <th>Delete</th>
         <th>Update</th>
      </tr>
      <%
         ResultSet result=(ResultSet)request.getAttribute("result");
         while(result.next()){
        	 String name=result.getString("name");
        	 String email=result.getString("email");
        	 String mobile=result.getString("mobile");
        	 
         
      %>
      <tr>
         <td><%= name %></td>
         <td><%= email %></td>
         <td><%= mobile %></td>
         <td><a href="deleteReg?email=<%= email %>">delete</a></td>
         <td><a href="updateReg?email=<%= email %>&mobile=<%= mobile%>">update</a></td>
         
      </tr>
      
      <%
         }
      %>
    </table>
</body>
</html>