package com.WanXinyu.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        super.init();
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        url="jdbc:sqlserver://localhost:databaseName=userdb1";
        username="sa";
        password="111111";


    }


    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        String user="select id from usertable where username=username and password=password";
        if(user != null){
            out.println("Login Success!!!");
            out.println("<br/>");
            out.println("Welcome,"+username+".");
        }else{
            out.println("Username or Password Error!!!");
        }

    }
}


