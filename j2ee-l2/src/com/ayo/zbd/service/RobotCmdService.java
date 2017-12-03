package com.ayo.zbd.service;

import com.ayo.zbd.model.CmdModel;
import com.ayo.zbd.repository.RobotCmdRepository;

import java.util.List;

public class RobotCmdService {

    public List<CmdModel> queryRobotCmdList(String cmd, String desc){
        return new RobotCmdRepository().queryRobotCmdList(cmd, desc);
    }

}
