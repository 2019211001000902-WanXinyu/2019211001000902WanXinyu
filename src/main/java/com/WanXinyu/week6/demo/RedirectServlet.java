package com.WanXinyu.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("before redirect ");

        //1.start without /
        //response.sendRedirect("index.jsp");
        //http://localhost:8080/2019211001000902WanXinyu_war_exploded/redirect
        //http://localhost:8080/2019211001000902WanXinyu_war_exploded/index.jsp

        System.out.println("after redirect ");
        //2.start with /
        //response.sendRedirect("/2019211001000902WanXinyu_war_exploded/index.jsp");//--???----404
        //http://localhost:8080/2019211001000902WanXinyu_war_exploded/redirect
        //http://localhost:8080/index.jsp

        response.sendRedirect("http://www.baidu.com/");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
