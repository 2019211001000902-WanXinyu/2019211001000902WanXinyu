package com.WanXinyu.week4.demo;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class JDBCServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getInitParameter("driver");
        String url=getServletConfig().getInitParameter("url");
        String username=getServletConfig().getInitParameter("username");
        String password=getServletConfig().getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birthdate=request.getParameter("date");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<table border=1><tr><td>id</td><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
        String sql2="select * from usertable";
        String sql1="insert into usertable(username,password,email,sex,birthdate) values('"+username+"','"+password+"','"+email+"','"+sex+"',"+birthdate+") ";
        try {

            ResultSet rst= con.createStatement().executeQuery(sql1);
            while(rst.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ResultSet rs = con.createStatement().executeQuery(sql2);
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("id")+"</td>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("sex")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
