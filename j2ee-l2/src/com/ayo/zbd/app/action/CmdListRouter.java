package com.ayo.zbd.app.action;

import com.alibaba.fastjson.JSON;
import com.ayo.zbd.base.RouterHandler;
import com.ayo.zbd.model.*;
import com.ayo.zbd.service.RobotCmdService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CmdListRouter extends RouterHandler {


    @Override
    public void doAction(String method, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyCmd = req.getParameter("cmd");
        String keyDesc = req.getParameter("desc");

        List<CmdModel> list = new RobotCmdService().queryRobotCmdList(keyCmd, keyDesc);
        System.out.println(JSON.toJSONString(list, true));

        req.setAttribute("messageList", list);
        req.setAttribute("keyCommand", keyCmd);
        req.setAttribute("keyDesc", keyDesc);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }
}
