<%--
  Created by IntelliJ IDEA.
  User: 万心雨
  Date: 2021/6/16
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
    </style>
    <script language="javascript">
        function isNumber(){
            var number1 = document.getElementById("firstValue").value;
            var number2 = document.getElementById("secondValue").value;
            if( number1 ) {
                if( isNaN( number1 ) ) {
                    alert('First value is not a Number');
                    return false;
                }
            } else {
                alert('Operand cannot be empty');
                return false;
            }
            if( number2 ) {
                if( isNaN( number2 ) ) {
                    alert('Second value is not a Number');
                    return false;
                }
            } else {
                alert('Operand cannot be empty');
                return false;
            }
            return true;
        }
        function isName(){
            var number1 = document.getElementById("name").value;
            if( number1 ) {
                if( !isNaN( number1 ) ) {
                    alert("Name is not valid");
                    return false;
                }
                else {
                    return true;
                }
            } else {
                alert('Operand cannot be empty');
                return false;
            }
        }
    </script>
</head>


<%
    Cookie[] cookies=request.getCookies();
    String firstValue="";
    String secondValue="";
    String result="";
    String name="";
    String length="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("cLength")){
                length=cookie.getValue();
            }
            if (cookie.getName().equals("cResult")){
                result=cookie.getValue();
            }
            if (cookie.getName().equals("cSecondValue")){
                secondValue=cookie.getValue();
            }
            if (cookie.getName().equals("cFirstValue")){
                firstValue=cookie.getValue();
            }
            if (cookie.getName().equals("cName")){
                name=cookie.getValue();
            }
        }
    }
%>
<body>
<form action="CalServlet" method="post">
    <table>
        <tr>
            <td>First val: <input type="text" name="firstValue" id="firstValue" autocomplete="off" value="<%=firstValue%>"></td>
            <td>Enter a name:<input type="text" name="name" id="name" autocomplete="off" value="<%=name%>"/></td>
        </tr>
        <tr>
            <td>Second val:<input type="text" name="secondValue" id="secondValue" autocomplete="off" value="<%=secondValue%>"/></td>
            <td>Length:      <input type="text" name="length" id="length" autocomplete="off" value="<%=length%>"/></td>
        </tr>
        <tr>
            <td>Result:    <input name="result" type="text" id="result" autocomplete="off" value="<%=result%>"/></td>
        </tr>
    </table>

    <input type="submit" name="add" id="1" value="Add" onclick="return isNumber()"/>
    <input type="submit" name="subtract" id="2" value="Subtract" onclick="return isNumber()"/>
    <input type="submit" name="multiply" id="3" value="Multiply" onclick="return isNumber()"/>
    <input type="submit" name="divide" id="4" value="Divide" onclick="return isNumber()"/>
    <input type="submit" name="computerLength" id="5" value="Computer Length" onclick="return isName()"/>
    <input type="reset" value="Reset" id="6" /><br><br>
</form>
</body>
</html>