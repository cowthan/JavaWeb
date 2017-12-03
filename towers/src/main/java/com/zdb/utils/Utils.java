package com.zdb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class Utils {
	
	public static String getFileContent(String path){
		
		File f = new File(path);
		if(!f.exists()){
			throw new RuntimeException("文件不存在！");
		}
		
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] buffer = new byte[1024];
			int len = 0;
			StringBuilder sb = new StringBuilder();
			while((len = fis.read(buffer)) != -1){
				sb.append(new String(buffer));
			}
			fis.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getContent(InputStream in){
		try {
			byte[] buffer = new byte[1024];
			int len = 0;
			StringBuilder sb = new StringBuilder();
			while((len = in.read(buffer)) != -1){
				sb.append(new String(buffer));
			}
			in.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static boolean isEmpty(Object o){
		if(o == null) return true;
		if(o.getClass() == String.class){
			return o.equals("");
		}else if(o instanceof Collection){
			return ((Collection)o).size() == 0;
		}else{
			return o == null;
		}
	}
	
	public static boolean isNotEmpty(Object o){
		return !isEmpty(o);
	}
	
	public static <T> boolean contains(T[] arr, T t){
		if(arr == null) return false;
		for(int i = 0; i < arr.length; i++){
			T tt = arr[i];
			if(tt.equals(t)){
				return true;
			}
		}
		return false;
	} 
	
}
