package com.webapp.controller;

import com.webapp.base.BaseServlet;
import com.webapp.util.freemarker.FreeMarker;
import freemarker.template.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet extends BaseServlet{

    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {
        // initialize operation
    }

    @Override
    public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> data = newData(req);
        data.put("user", "Big Joe");
        String result = FreeMarker.process(this, "", "index.ftl", data);

        responseHtml(resp, result);
    }
}
