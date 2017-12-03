package com.zdb.towers;

import java.util.List;

import com.zdb.bean.ImagePageInfo;
import com.zdb.bean.TieTower;


public interface TieTowerService {
	
	
	String createTower(TieTower g);
	List<TieTower> getAllTowers(int pageNow, int pageSize);
	ImagePageInfo getImageCount();
	void deleteAll();
	void deleteById(String id);
}
