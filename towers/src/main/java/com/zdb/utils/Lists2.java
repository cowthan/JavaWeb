package com.zdb.utils;

import java.util.List;

public class Lists2 {
	
	/**
	 * 返回list的第一个元素，如果没有，则返回null
	 * @param list
	 * @return
	 */
	public static <T> T getFirstElement(List<T> list){
		if(list == null || list.size() <= 0){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	public static <T> boolean isNullOrEmpty(List<T> list){
		return list == null || list.size() == 0;
	}
	
	public static <T> boolean isNotNullOrEmpty(List<T> list){
		return list != null && list.size() != 0;
	}
	
}
