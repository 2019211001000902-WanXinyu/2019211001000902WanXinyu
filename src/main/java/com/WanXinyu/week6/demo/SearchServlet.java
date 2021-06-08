package com.WanXinyu.week6.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        if (search.equals("baidu")) {
            if (txt.equals(null)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                response.sendRedirect("http://www.baidu.com/s?wd=" + txt);
            }
        }
        if (search.equals("bing")) {
            response.sendRedirect("https://cn.bing.com/search?q=" + txt);
        }
        if (search.equals("google")) {
            response.sendRedirect("https://www.google.com/search?q=" + txt);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}