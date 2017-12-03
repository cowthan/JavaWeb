package com.zdb.utils;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * fastjson的问题：
 * 1 序列化时，如果一个getter没有对应的成员变量，则序列化
 * 2 序列化时，如果一个private的成员变量，有getter，则默认不序列化
 * 3 序列化时，如果一个public的成员变量，则序列化
 * 
 * 日期格式问题：
 * public Date date;
 * 默认json的值是date: 毫秒数
 * 可以指定时间格式：
 * JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat);  //输出"2011-12-18 00:23:07"
 * JSON.toJSONStringWithDateFormat(bean, "yyyy-MM-dd HH:mm:ss.SSS"); // 
 * 
 * @author cowthan
 *
 */
public class JsonUtilsUseFast {
	
	
	public static void jsonToClient(HttpServletResponse resp, JsonResponseWrapper res){
		try {
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().write(toJson(res));
			resp.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static class JsonResponseWrapper{
		public int code;
		public String message;
		public Object result;

		public static JsonResponseWrapper getSuccessResponse(Object result){
			JsonResponseWrapper jrw = new JsonResponseWrapper();
			jrw.code = 0;
			jrw.message = "ok";
			jrw.result = result;
			return jrw;
		}
		
		public static JsonResponseWrapper getFailResponse(int code, String message){
			JsonResponseWrapper jrw = new JsonResponseWrapper();
			jrw.code = code;
			jrw.message = message;
			jrw.result = "";
			return jrw;
		}
	}
	
	/**
	 * 将目标对象转换成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
	
		if (obj == null) {
			return "{}";
		}
		return JSON.toJSONString(obj);
	}
	
	/**
	 * 将json字符串转换成目标class类型的对象
	 * 
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
	
		if (json == null || json.equals("") || clazz == null) {
			return null;
		}
		return (T) JSON.parseObject(json, clazz);
	}
	
	public static <T> List<T> toBeanList(String json, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		if (json == null || json.equals("") || clazz == null) {
			return list;
		}
		JSONArray arr = JSON.parseArray(json);
		for(int i = 0; i < arr.size(); i++){
			list.add(JSON.parseObject(arr.get(i).toString(), clazz));
		}
		return list;
	}
	
	
	/**
	 * 将json字符串转换成目标class类型的对象
	 * 
	 * @param json
	 * @param classType
	 * @param <T>
	 * @return
	 */
//	@SuppressWarnings("unchecked")
//	public static <T> T fromJson(String json, Type classType) {
//	
//		if (json == null || json.equals("") || classType == null) {
//			return null;
//		}
//		return (T) JSON.parseObject(json, classType);
//	}
}

