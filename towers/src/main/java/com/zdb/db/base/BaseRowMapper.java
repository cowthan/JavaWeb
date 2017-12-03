package com.zdb.db.base;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zdb.utils.Utils;


public class BaseRowMapper<T extends TableModel> implements RowMapper<T>{
	
	Class<T> clazz;
	public BaseRowMapper(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public T mapRow(ResultSet r, int arg1) throws SQLException {
		try {
			T t = clazz.newInstance();
			Field[] fs = clazz.getFields();
			for(Field f: fs){
				f.setAccessible(true);
				String columnName = t.getColumnName(f);
				Object val = null;
				//System.out.println("取出一列：" + columnName + "--" + f.getType().getSimpleName() + "," + clazz.getSimpleName());
				if(f.getType() == String.class){
					val = r.getString(columnName);
				}else if(f.getType() == int.class || f.getType() == Integer.class){
					val = r.getInt(columnName);
				}
				if(Utils.isNotEmpty(columnName)){
					f.set(t, val);
				}
			}
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
