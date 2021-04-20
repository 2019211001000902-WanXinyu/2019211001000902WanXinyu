<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/6
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
if(!(request.getAttribute("massage")==null)){
    //error
    out.println("<h3>"+request.getAttribute("massage")+"</h3>");
}
%>
<form method="post" action="login">
<table>
    <tr>
        <td><font  size="10" color="black">Login</font></td>
    </tr>
    <tr>
        <td>
            Username:<input type="text" name="username" >
        </td>
    </tr>
    <tr>
        <td>
            Password:<input type="text" name="password">
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit"  value="Login"/>
        </td>
    </tr>
</table>
</form>
<%@include file="footer.jsp"%>
