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
     <title>register</title>
</head>
<body>
<div>
    <p>New User Registration</p>
    <form method="post"   action="/2019211001000902WanXinyu_war_exploded/register">
        <table>
            <tr>
                <td width=350px><input style="width: 350px;height: 35px;background: khaki;font-size: large;border:0" type="text" name="username" placeholder="Username" autocomplete="off"></td>
            </tr>
            <tr>
                <td><input style="width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;"  type="password" name="password" placeholder="password" minlength="8"></td>
            </tr>
            <tr>
                <td><input style="width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;" type="email" name="email" placeholder="Email"></td>
            </tr>
            <tr>
                <td  style="width: 350px; height:35px">Gender:
                    <input  type="radio" name="sex" value="Male"  >Male
                    <input  type="radio" name="sex" value="Female" />Female</td>
            </tr>
            <tr>
                <td>
                    <input style="width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;" type="date" name="date" placeholder="Date of Birth(yyyy-mm-dd)">
                </td>
            </tr>
            <tr>
                <td>
                    <input style="color:azure;background: coral;width: 100px; height:35px;border:0" type="submit" name="register" value="Register">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>