<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/5
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>
<body>
This is Count JSP page.<br/>

<%! int getCount(){
    return ++count;
} %>
<%int count=0;%>
The page count is now (using count()): <%out.println(getCount());%>

</body>
</html>
