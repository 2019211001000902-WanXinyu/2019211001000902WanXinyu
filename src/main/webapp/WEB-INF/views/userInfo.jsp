<%@ page import="com.WanXinyu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/13
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Info</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>sex:</td><td><%=user.getSex()%></td></tr>
    <tr><td>birthdate:</td><%=user.getBirthdate()%></tr>
</table>
<%@include file="footer.jsp"%>