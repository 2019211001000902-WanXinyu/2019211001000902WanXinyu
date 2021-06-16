package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/lab3/CalServlet")
public class CalServlet extends HttpServlet {
    //1:add
    int add(int x,int y){
        return  x+y;
    }
    //2:subtract
    int subtract(int x,int y){
        return x-y;
    }
    //3:multiply
    int multiply (int x,int y){
        return x*y;
    }
    //4.divide
    int divide(int x,int y) {
        return x/y;
    }
    //5.computeLength
    int computeLength(String str) {
        return str.length();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("computerLength") != null){
            String str=request.getParameter("name").trim();
            int length=computeLength(str);
            Cookie cookie1=new Cookie("cName",str);
            Cookie cookie2=new Cookie("cLength",Integer.toString(length));

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            cookie1.setMaxAge(5);
            cookie2.setMaxAge(5);
        }else{

            String firstValue=request.getParameter("firstValue");
            String secondValue=request.getParameter("secondValue");
            int number1=Integer.valueOf(firstValue);
            int number2=Integer.valueOf(secondValue);

            int result=0;

            if(request.getParameter("add") != null){
                result=add(number1,number2);
            }else if(request.getParameter("subtract") != null){
                result=subtract(number1,number2);
            }else if(request.getParameter("multiply") != null){
                result=multiply(number1,number2);
            }else if(request.getParameter("divide") != null){

                result=divide(number1,number2);
            }
            Cookie cookie3=new Cookie("cFirstValue",Integer.toString(number1));
            Cookie cookie4=new Cookie("cSecondValue",Integer.toString(number2));
            Cookie cookie5=new Cookie("cResult",Integer.toString(result));

            response.addCookie(cookie3);
            response.addCookie(cookie4);
            response.addCookie(cookie5);

            cookie3.setMaxAge(5);
            cookie4.setMaxAge(5);
            cookie5.setMaxAge(5);
        }
        response.sendRedirect("/2019211001000902WanXinyu_war_exploded/lab3/cal.jsp");
    }
}