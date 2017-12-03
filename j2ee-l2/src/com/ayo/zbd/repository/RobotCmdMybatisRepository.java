package com.ayo.zbd.repository;

import com.ayo.zbd.db.DbAccess;
import com.ayo.zbd.model.CmdModel;
import com.ayo.zbd.model.form.CmdQueryForm;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RobotCmdMybatisRepository {
    DbAccess dbAccess = new DbAccess();

    public List<CmdModel> queryRobotCmdList(String keyCmd, String keyDesc){
        SqlSession session = null;
        try {
            session = dbAccess.getSqlSession();

            CmdQueryForm form = new CmdQueryForm();
            form.setCommand(keyCmd);
            form.setDescription(keyDesc);
            List<CmdModel> list = session.selectList("CmdModel.queryRobotCmdList2", form);
            return list;
//            BlogMapper mapper = session.getMapper(BlogMapper.class);
//            Blog blog = mapper.selectBlog(101);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public static void main(String[] args){
        RobotCmdMybatisRepository repo = new RobotCmdMybatisRepository();
        repo.queryRobotCmdList("", "");
    }
}
