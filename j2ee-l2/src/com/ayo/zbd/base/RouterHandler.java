package com.ayo.zbd.base;

import com.alibaba.fastjson.JSON;
import freemarker.template.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

public abstract class RouterHandler {

    public abstract void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public void log(String s){
        System.out.println(s);
    }

    public void responsePlainText(HttpServletResponse resp, String text) throws IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(text);
        out.flush();
    }

    public void responseHtml(HttpServletResponse resp, String text) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(text);
        out.flush();
    }
    public void responseJson(HttpServletResponse resp, Object obj) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String text = null;
        if(obj instanceof  String) text = (String) obj;
        else text = JSON.toJSONString(obj);
        out.println(text);
        out.flush();
    }

    public void responseFile(HttpServletResponse resp, File file) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
    }

}
