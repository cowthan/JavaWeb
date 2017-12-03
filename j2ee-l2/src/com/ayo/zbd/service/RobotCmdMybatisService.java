package com.ayo.zbd.service;

import com.ayo.zbd.model.CmdModel;
import com.ayo.zbd.repository.RobotCmdMybatisRepository;
import com.ayo.zbd.repository.RobotCmdRepository;

import java.util.List;

public class RobotCmdMybatisService {

    public List<CmdModel> queryRobotCmdList(String cmd, String desc){
        return new RobotCmdMybatisRepository().queryRobotCmdList(cmd, desc);
    }

}
