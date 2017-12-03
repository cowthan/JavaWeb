package com.zdb.db.base;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.alibaba.fastjson.annotation.JSONField;
import com.zdb.utils.Utils;


public class TableModel implements Serializable {
	
	@JSONField(serialize=false)
	public String getTableName(){
		Class<?> c = this.getClass();
		Table t = c.getAnnotation(Table.class);
		if(t == null){
			return c.getSimpleName().toLowerCase();
		}
		return t.name();
	}
	
	public String getColumnName(Field f){
		//System.out.println(f.getName());
		Field c = f;
		c.setAccessible(true);
		Column t = c.getAnnotation(Column.class);
		if(t == null){
			
		}else{
			return t.name();
		}
		
		Id id = c.getAnnotation(Id.class);
		if(id == null || id.name().equals("")){
			
		}else{
			return id.name();
		}
		
		NotColumn nc = c.getAnnotation(NotColumn.class);
		if(nc == null){
			return c.getName();
		}else{
			return "";
		}
	}
	
	public String getSqlColumn(Field f){
		Field c = f;
		Column t = c.getAnnotation(Column.class);
		if(t == null){
			
		}else{
			String res = t.name();
			NotNull nn = c.getAnnotation(NotNull.class);
			if(nn != null){
				res += " not null";
			}
			if(f.getType() == String.class){
				res += " default '" + t.defaultValue() + "', ";
			}else{
				res += ", ";
			}
			return res;
		}
		
		Id id = c.getAnnotation(Id.class);
		if(id == null){
			
		}else{
			return id.name() + " int primary key auto_increment, ";
		}
		
		NotColumn nc = c.getAnnotation(NotColumn.class);
		if(nc == null){
			return f.getName().toLowerCase();
		}else{
			return "";
		}
	}
	
	public boolean isId(Field f){
		f.setAccessible(true);
		Id id = f.getAnnotation(Id.class);
		if(id == null){
			return false;
		}else{
			return true;
		}
	}
	
	public String getColumnValue(Field f){
		
		try {
			Object o = f.get(this);
			if(f.getType().isPrimitive()){
				return o == null ? "0" : o.toString();
			}else{
				return  o == null ? "''" : "'" + o.toString() + "'";
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "''";
	}
	
	public String getInsertSql(){
		
		Class c = this.getClass();
		Field[] fs = c.getDeclaredFields();
		
		String sql = "insert into " + this.getTableName() + "(";
		//String values = ") "
		for(Field f: fs){
			f.setAccessible(true);
			String column = this.getColumnName(f);
			if(Utils.isNotEmpty(column) && !isId(f)){
				sql += column + ", ";
			}
		}
		
		sql = sql.substring(0, sql.length() - 2) + ") values( ";
		for(Field f: fs){
			f.setAccessible(true);
			String column = this.getColumnName(f);
			if(Utils.isNotEmpty(column) && !isId(f)){
				sql += this.getColumnValue(f) + ", ";
			}
		}
		sql = sql.substring(0, sql.length() - 2);
		sql += ");";
		
		return sql;
	}
	
	@JSONField(serialize=false)
	public String getUpdateSql(){
		
		Class c = this.getClass();
		Field[] fs = c.getDeclaredFields();
		
		String sql = "update " + this.getTableName() + " set ";
		//String values = ") "
		for(Field f: fs){
			f.setAccessible(true);
			String column = this.getColumnName(f);
			if(Utils.isNotEmpty(column) && !isId(f) && !column.equals("deviceId")){
				sql += column + " = " + this.getColumnValue(f) + ", ";
			}
		}
		
		sql = sql.substring(0, sql.length() - 2) + "";
//		for(Field f: fs){
//			String column = this.getColumnName(f);
//			if(Utils.isNotEmpty(column) || !isId(f)){
//				sql += this.getColumnValue(f) + ", ";
//			}
//		}
		//sql = sql.substring(0, sql.length() - 2);
		//sql += ");";
		
		return sql;
	}
	
	/**
	 * 获取update的sql语句
	 * @param updateColumns   需要update哪些列，如果指定了这个， 那参数2就不好使了
	 * @param excludeUpdateColumns  不需要update那些列
	 * @param whereColumns  以那几列作为where语句，这里指定的是and查询，没法or，如果非要or，那就做多次and吧暂时，如果不指定，则以id为条件
	 * @return
	 */
	public String getUpdateSql(String[] updateColumns, String[] excludeUpdateColumns, String[] whereColumns){
		
		Class c = this.getClass();
		Field[] fs = c.getDeclaredFields();
		
		String sql = "update " + this.getTableName() + " set ";
		//String values = ") "
		for(Field f: fs){
			f.setAccessible(true);
			String column = this.getColumnName(f);
			if(Utils.isNotEmpty(column) && !isId(f)){
				if(updateColumns == null || updateColumns.length == 0){
					///拼进所有列
					if(excludeUpdateColumns == null || excludeUpdateColumns.length == 0){
						sql += column + " = " + this.getColumnValue(f) + ", ";
					}else{
						if(Utils.contains(excludeUpdateColumns, column)){

						}else{
							sql += column + " = " + this.getColumnValue(f) + ", ";
						}
					}
					
				} else{
					///拼进指定的列
					if(Utils.contains(updateColumns, column)){
						sql += column + " = " + this.getColumnValue(f) + ", ";
					}else{
						
					}
				}
				
			}
		}
		
		sql = sql.substring(0, sql.length() - 2) + " where 1 = 1";
		
		
		//where column = value and c2 = v2;
		if(whereColumns == null || whereColumns.length == 0){
			///where语句就拼id吧
			for(Field f: fs){
				f.setAccessible(true);
				String column = this.getColumnName(f);
				if(Utils.isNotEmpty(column) && isId(f)){
					sql += " and " + column + " = " + this.getColumnValue(f);
				}
			}
			//sql = sql.substring(0, sql.length() - 2);
			sql += ";";
		}else{
			///where语句应该拼whereColumns指定的几个列，并且用and
			for(Field f: fs){
				f.setAccessible(true);
				String column = this.getColumnName(f);
				if(Utils.isNotEmpty(column) && Utils.contains(whereColumns, column)){
					sql += " and " + column + " = " + this.getColumnValue(f);
				}
			}
			//sql = sql.substring(0, sql.length() - 2);
			sql += ";";
		}
		
		return sql;
	}
	
	public String getDeleteSql(String[] whereColumns){
		//String sql = "delete from sms where boxType=" + sms.boxType + " and mid=" + sms.mid + " and deviceId = '"+sms.deviceId+"';";
		Class c = this.getClass();
		Field[] fs = c.getDeclaredFields();
		
		String sql = "delete from " + this.getTableName() + " where 1 = 1";
		//String values = ") "
		for(Field f: fs){
			f.setAccessible(true);
			String column = this.getColumnName(f);
			if(Utils.isNotEmpty(column) && Utils.contains(whereColumns, column)){
				sql += " and " + column + " = " + this.getColumnValue(f);
			}
		}
		
		sql += ";";
		
		
		return sql;
	} 
	
}
