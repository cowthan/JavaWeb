package com.zdb.bean;

import com.zdb.db.base.Id;
import com.zdb.db.base.Table;
import com.zdb.db.base.TableModel;

/**
 * 铁塔公司
 * @author cowthan
 *
 */
@Table(name="tieta")
public class TieTower extends TableModel{
	
	@Id
	public String id;
	public String gongsi;
	public String name;
	public String stateName;
	public String startTime;
	public String endTime;
	public String city;
	public String lat;
	public String lnt;
	public String status;
	public String addr;
	public String photo;
	public String thumb;
	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String motorType;
	
	
	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	public TieTower(){
		
	}
	
	public String getInfo(){
		return "name" + "<br />" + status + "<br />" + startTime + "<br />" + addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGongsi() {
		return gongsi;
	}

	public void setGongsi(String gongsi) {
		this.gongsi = gongsi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLnt() {
		return lnt;
	}

	public void setLnt(String lnt) {
		this.lnt = lnt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String calculateTime(){
		if(status.equals("发电开始")){
			return startTime; 
		}else{
			return endTime;
		}
	}
	
	
}
