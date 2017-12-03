package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AppController {
    @WebServlet(urlPatterns = "/app/list")
    public static class ListServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_list.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/app/add")
    public static class AddServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_add.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/app/update")
    public static class UpdateServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_add.ftl", data);
            responseHtml(resp, result);
        }
    }


    @WebServlet(urlPatterns = "/api/app/save")
    public static class ApiAddServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ssss");
        }
    }

    @WebServlet(urlPatterns = "/api/app/delete")
    public static class DeleteServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ddd");
        }
    }
}
