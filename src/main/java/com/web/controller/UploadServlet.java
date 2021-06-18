package com.web.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;



//@WebServlet(urlPatterns = {"/controller/upload/file", "/controller/upload/image"})
@WebServlet("/controller/upload/*") // 後置路徑對應 * 代表任意字串(path info)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 30
)
public class UploadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        
        String pathInfo = req.getPathInfo();
        resp.getWriter().print("pathInfo:" +  pathInfo + "<p />");
        
        switch(pathInfo) {
            case "/file":
                uploadFile(req, resp);
                break;
            case "/image":
                uploadImage(req, resp);
                break;    
        }
    }
    
    private void uploadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("cname"))
                .forEach(part -> {
                    try {
                        String cname = IOUtils.toString(part.getInputStream(), 
                                                        StandardCharsets.UTF_8.name());
                        resp.getWriter().print(part.getName() + " : ");
                        resp.getWriter().print(cname + "<br />");
                    } catch (Exception e) {
                    }
                });
        
        req.getParts()
                .stream()
                .filter(part -> part.getName().equals("upload_file"))
                .forEach(part -> {
                    try {
                        String data = IOUtils.toString(part.getInputStream(), 
                                                        StandardCharsets.UTF_8.name());
                        resp.getWriter().print(part.getName() + " : ");
                        resp.getWriter().print(data + "<br />");
                    } catch (Exception e) {
                    }
                });
    }

    private void uploadImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}