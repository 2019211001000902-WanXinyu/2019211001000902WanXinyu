<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/3/14
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Title</title>
    <style>
          .a1{font-family: 黑体;font-size: x-large;}
          .a2{width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;}
          .a3{width: 70px;height: 35px;background: coral;}
    </style>
</head>
<body bgcolor="#f5f5dc">
<div class="a1"><br/><br/>
       New User Registration!<br/><br/>
</div>
       <input type="text" name="username" class="a2" placeholder="Username"><br/><br/>
       <input type="password" name="password" class="a2" placeholder="password" minlength="8"><br/><br/>
       <input type="email" name="email" class="a2" placeholder="Email"><br/><br/>
        <form>
          Gender:
          <input name="sex" type="radio" value="Male"/>Male
          <input name="sex" type="radio" value="Female"/>Female
        </form>
        <input type="date" name="birth-data" class="a2" placeholder="Date of Birth(yy-mm-dd)"><br/><br/>
        <button class="a3">Register</button>

</body>
</html>
