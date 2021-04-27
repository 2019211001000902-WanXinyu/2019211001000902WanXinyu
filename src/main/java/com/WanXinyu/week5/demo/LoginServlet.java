package com.WanXinyu.week5.demo;
import com.WanXinyu.dao.UserDao;
import com.WanXinyu.model.User;


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
        super.init();

        /*String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
*/

        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //String email=request.getParameter("email");
        //String sex=request.getParameter("sex");
        //String birthdate=request.getParameter("birthdate");

        UserDao userDao=new UserDao();
        try {
           User user= userDao.findByUsernamePassword(con,username,password);
            if(user!=null){

                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe != null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);

                /*Cookie c=new Cookie("sessionid",""+user.getId());
                c.setMaxAge(10*60);
                response.addCookie(c);
                */

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //PrintWriter writer = response.getWriter();

        /*String sql="select username,password from usertable where username='"+username+"' and password='"+password+"'";

        try {
            System.out.println("con:" + con);

            ResultSet rs = con.createStatement().executeQuery(sql);

            if (rs.next()) {
                //writer.println("Login Success!!!");
                //writer.println("Welcome"+username+".");
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("sex", rs.getString("sex"));
                request.setAttribute("birthdate", rs.getString("birthdate"));
                //forward to user info jsp
                request.getRequestDispatcher("userlist.jsp").forward(request, response);
            } else {
                //writer.println("Username or Password Error!!!");
                request.setAttribute("message", "User Or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
*/
    }
}

