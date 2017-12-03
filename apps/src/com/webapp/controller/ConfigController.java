package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ConfigController {
    @WebServlet(urlPatterns = "/config/list")
    public static class ListServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_config.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/api/config/save")
    public static class SaveServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "");
        }
    }
    @WebServlet(urlPatterns = "/api/config/delete")
    public static class DeleteServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "");
        }
    }

    @WebServlet(urlPatterns = "/api/config/list")
    public static class QueryServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "dddd");
        }
    }
}
