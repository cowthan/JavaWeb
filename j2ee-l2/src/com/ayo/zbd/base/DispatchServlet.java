package com.ayo.zbd.base;

import com.ayo.zbd.app.RouterManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="DispatchServlet", urlPatterns = "/")
public class DispatchServlet extends BaseServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        RouterManager.init();
    }

    @Override
    public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("<h1>这是一个响应2</h1>");
//        out.flush();
        resp.addHeader("Access-Control-Allow-Origin", "*");
        String requestURI = req.getRequestURI();//?之前   端口号之后  //  值是：“/sfsf/ldf.jsp”
        RouterHandler handler = Router.getDefault().getRouterHandler(requestURI, method);
        if(handler == null){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("404，找不到请求：" + requestURI);
            out.flush();
        }else{
            try {
                handler.doAction(method, req, resp);
            }catch (Exception e){
                e.printStackTrace();
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println("500，处理过程出错了:" + e.getMessage());
                out.flush();
            }
        }
    }
}
