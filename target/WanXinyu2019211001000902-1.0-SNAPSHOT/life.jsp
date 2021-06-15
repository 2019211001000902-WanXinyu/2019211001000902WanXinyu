<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/5
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    //java code here
    public void jspInit(){
        System.out.println("i am in jspinit()");//when?
    }
%><!---service---->

<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am in jspservice()");%>
</body>
</html>
<!---service---->
<%!
    public void jspDestory(){
        System.out.println("i am in jspDestory()");
    }
%>
