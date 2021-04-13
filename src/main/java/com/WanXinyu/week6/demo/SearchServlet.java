package com.WanXinyu.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get parameter  <input type="text" name="txt" size=30/> and
        //get parameter  <select name="search">
        //check is txt null
        String txt=request.getParameter("txt");
        String search=request.getParameter("search");
        if ("".equals(txt)) {
            //redirect to home page  --index2.jsp
            response.sendRedirect("index.jsp");
        }
        else{
            if("Baidu".equals(search)){ response.sendRedirect("https://www.baidu.com/s?wd="+txt); }//redirect to baidu

            else if ("Bing".equals(search)){ response.sendRedirect("https://cn.bing.com/?scope=web="+txt); }

            else if("Google".equals(search)){ response.sendRedirect("https://www.google.cn/="+txt); }
        }//end doget


    }//end class

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
