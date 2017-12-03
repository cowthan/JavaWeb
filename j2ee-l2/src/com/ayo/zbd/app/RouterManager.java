package com.ayo.zbd.app;

import com.ayo.zbd.app.action.CmdListMybatisRouter;
import com.ayo.zbd.app.action.DbRouter;
import com.ayo.zbd.app.action.CmdListRouter;
import com.ayo.zbd.base.Router;

public class RouterManager {
//    private RouterManager(){}
//
//    private static final RouterManager instance = new RouterManager();
//
//    public static RouterManager getDefault(){
//        return instance;
//    }

    public static void init(){

        System.out.println("-----------------------初始化路由------------------");
        Router.getDefault().addRouter("/db/list", "get", new DbRouter());
        Router.getDefault().addRouter("/cmd/list", "get", new CmdListRouter());
        Router.getDefault().addRouter("/cmd/list2", "get", new CmdListMybatisRouter());
    }

}
