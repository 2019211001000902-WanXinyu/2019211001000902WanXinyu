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
<%
   Cookie[] allCookies=request.getCookies();
   String username="",password="",rememberMeVal="";
   if(allCookies != null){
       for (Cookie c:allCookies) {
           if (c.getName().equals("cUsername")){
               username=c.getValue();
           }
           if (c.getName().equals("cPassword")){
               password=c.getValue();
           }
           if (c.getName().equals("cRememberMe")){
               rememberMeVal=c.getValue();
           }
       }
   }
%>
<form method="post" action="login">
<table>
    <tr><td><font  size="10" color="black">Login</font></td></tr>
    <tr><td>Username:<input type="text" name="username" value="<%=username%>"></td></tr>
    <tr><td>Password:<input type="text" name="password" value="<%=password%>"></td></tr>
    <tr><td><input type="checkbox" name="rememberMe" value="1"<%=rememberMeVal.equals("1")?"checked":""%> checked>RememberMe</td></tr>
    <tr><td><input type="submit"  value="Login"/></td></tr>
</table>
</form>
<%@include file="footer.jsp"%>
