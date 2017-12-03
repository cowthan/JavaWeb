package com.ayo.zbd.base;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private Router(){}

    private static final Router instance = new Router();

    public static Router getDefault(){
        return instance;
    }

    private Map<String, RouterHandler> routers = new HashMap<>();

    public void addRouter(String uri, String method, RouterHandler handler){
        routers.put(uri, handler);
    }

    public RouterHandler getRouterHandler(String uri, String method){
        return routers.get(uri);
    }

}
