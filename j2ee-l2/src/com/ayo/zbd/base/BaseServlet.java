package com.ayo.zbd.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("get", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("post", req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("delete", req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("put", req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("head", req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("option", req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action("trace", req, resp);
    }

    private void action(String method, HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        String method1=req.getMethod();//获取请求方式
        String scheme=req.getScheme();//获取协议
        String path=req.getContextPath();//获取根目录      /根目录
        String queryString=req.getQueryString();//?后面的参数
        String requestURI=req.getRequestURI();//?之前   端口号之后
        StringBuffer requestURL=req.getRequestURL();//?之前所有的内容

        log("\n----------收到请求：" + method + ", " + requestURL.toString());
        System.out.println("method:"+method1);
        System.out.println("scheme:"+scheme);
        System.out.println("path:"+path);
        System.out.println("queryString:"+queryString);
        System.out.println("reuqestURI:"+requestURI);
        System.out.println("requestURL:"+requestURL);

        String userAgent=req.getHeader("user-agent");
        String host=req.getHeader("HOst");
        System.out.println("host:"+host);
        System.out.println("userAgent:"+userAgent);

        String remoteAddr=req.getRemoteAddr();
        int remotePort=req.getRemotePort();
        String localAddr=req.getLocalAddr();
        int localPort=req.getLocalPort();

        System.out.println("remoteAddr:"+remoteAddr);
        System.out.println("remotePort:"+remotePort);
        System.out.println("localAddr:"+localAddr);
        System.out.println("localPort:"+localPort);

        doAction(method, req, resp);
        log("----------请求结束-----------\n");
    }

    public abstract void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public void log(String s){
        System.out.println(s);
    }
}
