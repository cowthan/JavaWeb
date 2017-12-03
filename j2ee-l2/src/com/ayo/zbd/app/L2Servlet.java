package com.ayo.zbd.app;

import com.ayo.zbd.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="L2Servlet", urlPatterns = "/l2")
public class L2Servlet extends BaseServlet {
    @Override
    public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<h1>这是一个响应</h1>");
        out.flush();
    }
}
