package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class HomeController {
    @WebServlet(urlPatterns = "/home")
    public static class HomeServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_index.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/login")
    public static class LoginServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_login.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/register")
    public static class RegisterServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_register.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/forget_password")
    public static class ForgetPasswordServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_pwd_forget.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/download")
    public static class DownloadServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_home_download.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/price")
    public static class PriceServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_home_price.ftl", data);
            responseHtml(resp, result);
        }
    }
}
