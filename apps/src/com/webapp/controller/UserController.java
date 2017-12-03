package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UserController {
    @WebServlet(urlPatterns = "/user/info")
    public static class UserInfoServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_user_info.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/user/bill")
    public static class BillServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_bill.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/api/user/login")
    public static class LoginServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "dddd");
        }
    }

    @WebServlet(urlPatterns = "/api/user/register")
    public static class RegisterServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ddddd");
        }
    }

    @WebServlet(urlPatterns = "/api/user/forget_pwd")
    public static class ForgetPasswordServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ddd");
        }
    }
}
