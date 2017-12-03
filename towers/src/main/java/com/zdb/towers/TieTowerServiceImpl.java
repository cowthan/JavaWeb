package com.zdb.towers;

import java.util.List;

import javax.inject.Inject;

import com.zdb.bean.ImagePageInfo;
import com.zdb.bean.TieTower;
import com.zdb.exception.PiaPiaDaoException;
import com.zdb.exception.PiaPiaServiceException;


public class TieTowerServiceImpl implements TieTowerService{

	@Inject
	private TieTowerDao towerDao;
	
	@Override
	public String createTower(TieTower g) {
		try {
			return towerDao.insert(g);
		} catch(PiaPiaDaoException e){
			e.printStackTrace();
			throw new PiaPiaServiceException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaServiceException("业务逻辑异常：" + e.getMessage());
		}
	}
	@Override
	public ImagePageInfo getImageCount() {
		try {
			ImagePageInfo p = new ImagePageInfo();
			p.totalNum = towerDao.queryCount();
			p.pageSize = 9;
			p.pageNow = -1;
			p.pageCount = p.totalNum / p.pageSize;
			int left = p.totalNum % p.pageSize;
			if(left == 0){
				
			}else{
				p.pageCount += 1;
			}
			return p;
		} catch(PiaPiaDaoException e){
			e.printStackTrace();
			throw new PiaPiaServiceException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaServiceException("业务逻辑异常：" + e.getMessage());
		}
	}
	@Override
	public List<TieTower> getAllTowers(int pageNow, int pageSize) {
		try {
			List<TieTower> list = towerDao.queryAll(pageNow, pageSize);
			return list;
		} catch(PiaPiaDaoException e){
			e.printStackTrace();
			throw new PiaPiaServiceException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaServiceException("业务逻辑异常：" + e.getMessage());
		}
	}
	@Override
	public void deleteAll() {
		try {
			towerDao.deleteAll();
		} catch(PiaPiaDaoException e){
			e.printStackTrace();
			throw new PiaPiaServiceException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaServiceException("业务逻辑异常：" + e.getMessage());
		}
	}
	@Override
	public void deleteById(String id) {
		try {
			towerDao.deletById(id);
		} catch(PiaPiaDaoException e){
			e.printStackTrace();
			throw new PiaPiaServiceException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new PiaPiaServiceException("业务逻辑异常：" + e.getMessage());
		}
		
	}

}
