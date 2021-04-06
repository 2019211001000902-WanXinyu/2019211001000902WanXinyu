package com.WanXinyu.week5.demo;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection con;

    public void init() throws ServletException{

        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        PrintWriter writer = response.getWriter();

        try {
            System.out.println("con:"+con);
            String sql="select * from usertable where username='"+username+"' and password='"+password+"'";
            ResultSet  rs= con.createStatement().executeQuery(sql);

            if(rs.next()){
                writer.println("Login Success!!!");
                writer.println("Welcome"+username+".");
            }
            else {
                writer.println("Username or Password Error!!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

