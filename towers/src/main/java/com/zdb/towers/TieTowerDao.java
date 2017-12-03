package com.zdb.towers;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zdb.bean.ImageCount;
import com.zdb.bean.TieTower;
import com.zdb.db.base.BaseRowMapper;
import com.zdb.exception.PiaPiaDaoException;
import com.zdb.utils.Lists2;
import com.zdb.utils.LogUtils;


/**
 * 
 * @author cowthan
 *
 */
public class TieTowerDao extends JdbcDaoSupport{
	
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	public TieTowerDao(DataSource dataSource) {
		this.setDataSource(dataSource);
		jdbcTemplate = getJdbcTemplate();
	}
	
	public String insert(TieTower bean){
		try {
			String sql = bean.getInsertSql();
			LogUtils.log(sql);
			this.jdbcTemplate.execute(sql);
			
			//获取刚插入的id
			sql = "select * from tieta order by id desc limit 0,1;";
			List<TieTower> list = this.jdbcTemplate.query(sql, new BaseRowMapper<TieTower>(TieTower.class));
			TieTower g = Lists2.getFirstElement(list);
			if(g == null){
				throw new PiaPiaDaoException("查不到刚插入的数据");
			}else{
				return g.id+"";
			}
			///return "";
		} catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
		}
	}
	
	public String deleteAll(){
		try {
			String sql = "delete from tieta;";
			LogUtils.log(sql);
			this.jdbcTemplate.execute(sql);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
		}
	}
	
	public String deletById(String id){
		try {
			String sql = "delete from tieta where id = {id};".replace("{id}", id);
			LogUtils.log(sql);
			this.jdbcTemplate.execute(sql);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
		}
	}
	
//	public boolean delete(GirlImage bean){
//		try {
//			String sql = bean.getDeleteSql(new String[]{"id"});
//			LogUtils.log(sql);
//			int row = this.jdbcTemplate.update(sql);
//			return row == 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
//		}
//	}
	
//	public boolean updateGifThumb(GirlImage bean){
//		try {
//			String sql = bean.getUpdateSql(new String[]{"thumbStaticOfGif"}, null, new String[]{"id"});
//			LogUtils.log(sql);
//			int row = this.jdbcTemplate.update(sql);
//			return row == 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
//		}
//	}
	
	/**
	 * 检查一个七牛的key是否已经在数据库中
	 * @param key
	 */
//	public boolean isAlreadyInDB(String bucket, String qiniuKey){
//		try {
//			String sql = "select id from qiniu_image where bucket = '{bucket}' and qiniuKey = '{qiniuKey}' limit 0, 1;";
//			sql = sql.replace("{bucket}", bucket).replace("{qiniuKey}", qiniuKey);
//			System.out.println(sql);
//			List<ImageExsitence> list = this.jdbcTemplate.query(sql, new BaseRowMapper<ImageExsitence>(ImageExsitence.class));
//			System.out.println(list.size());
//			return !Lists2.isNullOrEmpty(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
//		}
//	}
	
	public TieTower queryById(String id){
		try {
			String sql = "select * from tieta where id = {id};";
			sql = sql.replace("{id}", id);
			LogUtils.log(sql);
			List<TieTower> list = this.jdbcTemplate.query(sql, new BaseRowMapper<TieTower>(TieTower.class));
			return Lists2.getFirstElement(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
		}
	}
	
	public List<TieTower> queryAll(int pageNow, int pageSize){
		try {
			String sql = "select * from tieta order by id desc limit {offset}, {rowNum};";
			int offset = (pageNow) * pageSize;
			int rowNum = pageSize;
			sql = sql.replace("{offset}", offset+"").replace("{rowNum}", rowNum+"");
			LogUtils.log(sql);
			List<TieTower> list = this.jdbcTemplate.query(sql, new BaseRowMapper<TieTower>(TieTower.class));
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
		}
	}
	
	public int queryCount(){
		try {
			String sql = "select count(id) as num from tieta;";
			LogUtils.log(sql);
			List<ImageCount> list = this.jdbcTemplate.query(sql, new BaseRowMapper<ImageCount>(ImageCount.class));
			return list.get(0).num;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
		}
	}

//	public List<GirlImage> queryImageList(int pageNow, int pageSize) {
//		try {
//			String sql = "select * from qiniu_image where type=1 limit {offset}, {rowNum};";
//			int offset = (pageNow) * pageSize;
//			int rowNum = pageSize;
//			sql = sql.replace("{offset}", offset+"").replace("{rowNum}", rowNum+"");
//			LogUtils.log(sql);
//			List<GirlImage> list = this.jdbcTemplate.query(sql, new BaseRowMapper<GirlImage>(GirlImage.class));
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
//		}
//	}
//
//	public List<GirlImage> queryGifList(int pageNow, int pageSize) {
//		try {
//			String sql = "select * from qiniu_image where type=2 limit {offset}, {rowNum};";
//			int offset = (pageNow) * pageSize;
//			int rowNum = pageSize;
//			sql = sql.replace("{offset}", offset+"").replace("{rowNum}", rowNum+"");
//			LogUtils.log(sql);
//			List<GirlImage> list = this.jdbcTemplate.query(sql, new BaseRowMapper<GirlImage>(GirlImage.class));
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PiaPiaDaoException("数据库异常：" + e.getMessage());
//		}
//	}
}
