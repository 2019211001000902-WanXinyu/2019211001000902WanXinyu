<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/6
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="/2019211001000902WanXinyu_war_exploded/login">
    Username:<input style="width: 200px; height:30px" type="text" name="username" autocomplete="off"><br/><br/>
    Password:<input style="width: 200px; height:30px" type="password" name="password"  minlength="8"><br/><br/>
    <input style="width: 80px; height:30px" type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>