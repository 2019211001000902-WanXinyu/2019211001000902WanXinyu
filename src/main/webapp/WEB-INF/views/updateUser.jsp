<%@page import="com.WanXinyu.model.User" %>><%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/4/27
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
   User u=(User) session.getAttribute("user");
%>
<form method="post"    action="updateUser">
    <table>
        <tr>
            <td width=350px><input style="width: 350px;height: 35px;background: khaki;font-size: large;border:0" type="hidden" name="id" value="<%=u.getId()%>"></td>
        </tr>
        <tr>
            <td><input style="width: 350px;height: 35px;background: khaki;font-size: large;border:0" type="text" name="username" value="<%=u.getUsername()%>" placeholder="Username" autocomplete="off"></td>
        </tr>
        <tr>
            <td><input style="width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;"  type="password" name="password" value="<%=u.getPassword()%>" placeholder="password" minlength="8"></td>
        </tr>
        <tr>
            <td><input  style="width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;" type="email" name="email" value="<%=u.getEmail()%>" placeholder="Email"></td>
        </tr>
        <tr>
            <td  style="width: 350px; height:35px">Gender:
                <input  type="radio" name="sex" value="Male" <%="Male".equals(u.getSex()) ?"checked" :""%> >Male
                <input  type="radio" name="sex" value="Female" <%="Female".equals(u.getSex()) ?"checked" :""%>/>Female</td>
        </tr>
        <tr>
            <td>
                <input style="width: 350px;height: 35px;background: khaki; border: 0px;font-size: large;" type="date" name="birthdate" value="<%=u.getBirthdate()%>" placeholder="Date of Birth(yyyy-mm-dd)">
            </td>
        </tr>
        <tr>
            <td>
                <input style="color:azure;background: coral;width: 100px; height:35px;border:0" type="submit"  value="Save Changes"/>
            </td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp"%>