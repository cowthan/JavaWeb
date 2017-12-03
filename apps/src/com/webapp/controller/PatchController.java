package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class PatchController {
    @WebServlet(urlPatterns = "/patch/list")
    public static class ListServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_patch_list.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/patch/detail")
    public static class DetailServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_patch_detail.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/patch/data")
    public static class DataServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_patch_data.ftl", data);
            responseHtml(resp, result);
        }
    }


    @WebServlet(urlPatterns = "/patch/data/detail")
    public static class DataDetailServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_patch_data_detail.ftl", data);
            responseHtml(resp, result);
        }
    }

    @WebServlet(urlPatterns = "/patch/add")
    public static class AddServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, Object> data = newData(req);
            String result = FreeMarker.process(this, "", "app/tp_app_version_patch_add.ftl", data);
            responseHtml(resp, result);
        }
    }

//    @WebServlet(urlPatterns = "/patch/update")
//    public static class UpdateServlet extends BaseServlet {
//        @Override
//        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            Map<String, Object> data = newData(req);
//            String result = FreeMarker.process(this, "", "app/tp_app_version_patch_add.ftl", data);
//            responseHtml(resp, result);
//        }
//    }

    @WebServlet(urlPatterns = "/api/patch/add")
    public static class ApiAddServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "");
        }
    }

    @WebServlet(urlPatterns = "/api/patch/delete")
    public static class DeleteServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "sdsdsd");
        }
    }

    @WebServlet(urlPatterns = "/api/patch/check")
    public static class CheckPatchVersionServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ssdsdsd");
        }
    }


    @WebServlet(urlPatterns = "/api/patch/update")
    public static class UpdateServlet extends BaseServlet {
        @Override
        public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            responseHtml(resp, "ssdsdsd");
        }
    }
}
