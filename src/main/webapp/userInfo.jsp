<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/13
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Info</h1>

<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>sex:</td><td><%=%>request.getAttribute("sex")%></td></tr>
    <tr><td>birthdate:</td><%=request.getAttribute("birthdate")%></tr>
</table>
<%@include file="footer.jsp"%>