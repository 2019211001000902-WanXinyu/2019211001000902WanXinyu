package com.WanXinyu.week3.demo;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost;databaseName=userHHx";
        //String username="sa";
        //String password="admin123456789";
        //ServletConfig config=getServletConfig();
        String driver=getServletConfig().getInitParameter("driver");
        String url=getServletConfig().getInitParameter("url");
        String username=getServletConfig().getInitParameter("username");
        String password=getServletConfig().getInitParameter("password");

        /*String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        }*/
        con= (Connection) getServletContext().getAttribute("con");
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
            //PrintWriter writer= response.getWriter();
            //writer.println("<br>username: "+username);
            //writer.println("<br>password: "+Password);
            //writer.println("<br>email: "+email);
            //writer.println("<br>gender: "+sex);
            //writer.println("<br>birth date: "+date);
            //writer.close();
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
                Statement st=con.createStatement();
                String sql3="insert into usertable(username,password,email,sex,birthdate) values('"+username+"','"+password+"','"+email+"','"+sex+"',"+birthdate+")";
                System.out.println("sql3"+sql3);
                int n=st.executeUpdate(sql3);
                System.out.println("n-->"+n);
                // sql3="select id,username,password,email,sex,birthdate from usertable";
                //ResultSet rs=st.executeQuery(sql3);
                //PrintWriter out= response.getWriter();
            /*out.println("<html><title></title><body><table border=1><tr>");
            out.println("<td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
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
            out.println("</table></body></html>");*/
                // request.setAttribute("rsname",rs);
                //request.getRequestDispatcher("userList.jsp").forward(request,response);
                //System.out.println("i am in RegisterServlet-->doPost()-->after forward()");
                response.sendRedirect("login.jsp");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }