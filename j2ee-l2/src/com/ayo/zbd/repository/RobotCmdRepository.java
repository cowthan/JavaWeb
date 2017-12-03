package com.ayo.zbd.repository;

import com.ayo.zbd.model.CmdModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RobotCmdRepository {

    public List<CmdModel> queryRobotCmdList(String keyCmd, String keyDesc){
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://rm-bp16ad3ce8188drq6o.mysql.rds.aliyuncs.com/robot?characterEncoding=utf-8&useSSL=false",
                    "root",
                    "cowthan_777");
            String sql = "SELECT * FROM message where 1 = 1";

            int likeIndex = -1;
            boolean useLike = false;

            List<String> paramList = new ArrayList<>();
            if(keyCmd != null && !"".equals(keyCmd.trim())){
                sql += " and command=?";
                paramList.add(keyCmd);
                likeIndex++;
            }
            if(keyDesc != null && !"".equals(keyDesc.trim())){
                sql += " and description like ?";
                paramList.add(keyDesc);
                useLike = true;
                likeIndex++;
            }
            PreparedStatement statement = conn.prepareStatement(sql);
            for (int i = 0; i < paramList.size(); i++) {
                if(useLike && i == likeIndex){
                    statement.setString(i + 1, "%" + paramList.get(i) + "%");
                }else{
                    statement.setString(i + 1, paramList.get(i));
                }
            }

            System.out.println(statement.toString());
            rs = statement.executeQuery();

            List<CmdModel> list = new ArrayList<>();
            while(rs.next()){
                CmdModel cmd = new CmdModel();
                cmd.id = rs.getInt("id");
                cmd.command = rs.getString("command");
                cmd.description = rs.getString("description");
                cmd.content = rs.getString("content");
                list.add(cmd);
            }
            rs.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
