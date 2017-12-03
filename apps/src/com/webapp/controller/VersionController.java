package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class VersionController {
    @WebServlet(urlPatterns = "/version/list")
    public static class ListServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_list.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/version/add")
    public static class AddServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_add.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/version/update")
    public static class UpdateServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_add.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/api/version/save")
    public static class SaveServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ssdsdsd");
        }
    }

    @WebServlet(urlPatterns = "/api/version/delete")
    public static class DeleteServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "sdsdsd");
        }
    }

    @WebServlet(urlPatterns = "/version/check")
    public static class CheckVersionServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ssdsdsd");
        }
    }
}
