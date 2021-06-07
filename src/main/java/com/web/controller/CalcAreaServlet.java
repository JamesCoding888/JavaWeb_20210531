package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/CalcArea") // url-pattern
public class CalcAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Sorry~~"); 
    }
            //避免當使用者手不小心按照網址並按下 Enter 按鍵後，出現底下訊息，他們會緊張地!!! 因此在doGet方法修改上 Sorry
            //HTTP Status 405 – Method Not Allowed
            //TypeStatus Report
            //MessageHTTP method GET is not supported by this URL
            //DescriptionThe method received in the request-line is known by the origin server 
            //but not supported by the target resource.
            //Apache Tomcat/9.0.46    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string_r = req.getParameter("r");
        int r = Integer.parseInt(string_r);
        double area = Math.pow(r, 2) * Math.PI;
        resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }
}