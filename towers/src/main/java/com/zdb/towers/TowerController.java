package com.zdb.towers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Strings;
import com.zdb.bean.ImagePageInfo;
import com.zdb.bean.RespCreate;
import com.zdb.bean.TieTower;
import com.zdb.utils.ExcelUtils;
import com.zdb.utils.JsonUtilsUseFast;
import com.zdb.utils.JsonUtilsUseFast.JsonResponseWrapper;
import com.zdb.utils.LogUtils;


@Controller
@RequestMapping("tower")
public class TowerController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	
	@Inject
	private TieTowerService tieTowerService;
	

	/**
	 * 从数据库获取所有图片
	 * @param req
	 * @param resp
	 * @param model
	 * @param pageNow
	 * @param pageSize
	 */
	//http://192.168.1.111:8080/tower/add
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest req, HttpServletResponse resp,
			Model model, TieTower t) {
		try {
			TieTower tower = t; //new TieTower();
//			tower.gongsi = new String(t.gongsi.getBytes("iso-8859-1"), "utf-8");;
//			tower.name = new String(t.name.getBytes("iso-8859-1"), "utf-8");
//			tower.stateName = new String(t.stateName.getBytes("iso-8859-1"), "utf-8");;
//			tower.startTime = new String(t.startTime.getBytes("iso-8859-1"), "utf-8");;
//			tower.endTime = new String(t.endTime.getBytes("iso-8859-1"), "utf-8");;
//			tower.city = new String(t.city.getBytes("iso-8859-1"), "utf-8");;
//			tower.lat = new String(t.lat.getBytes("iso-8859-1"), "utf-8");;
//			tower.lnt = new String(t.lnt.getBytes("iso-8859-1"), "utf-8");;
//			tower.status = new String(t.status.getBytes("iso-8859-1"), "utf-8");;
//			tower.addr = new String(t.addr.getBytes("iso-8859-1"), "utf-8");;
//			tower.motorType = new String(t.motorType.getBytes("iso-8859-1"), "utf-8");;
//			tower.photo = new String(t.photo.getBytes("iso-8859-1"), "utf-8");
			
//			System.out.println(JsonUtilsUseFast.toJson(tower));
//			String path = FileUploadHandler.fileUpload(req, resp);
//			System.out.println(path);
			
			
			RespCreate r = new RespCreate();
			r.id = tieTowerService.createTower(tower);
			JsonUtilsUseFast.jsonToClient(resp, JsonResponseWrapper.getSuccessResponse(r));
		} catch (Exception e) {
			e.printStackTrace();
			JsonUtilsUseFast.jsonToClient(resp, JsonResponseWrapper.getFailResponse(1, "插入失败：" + e.getLocalizedMessage()));
		}
	}
	
	/**
	 * 从数据库获取所有图片：只查询图片
	 * @param req
	 * @param resp
	 * @param model
	 * @param pageNow
	 * @param pageSize
	 */
	@RequestMapping(value = "/list")
	public void getTowerList(HttpServletRequest req, HttpServletResponse resp,
			Model model, String pageNow, String pageSize) {
		System.out.println(pageNow + ", " + pageSize);
		if(Strings.isNullOrEmpty(pageNow)) pageNow = "0";
		if(Strings.isNullOrEmpty(pageSize)) pageSize = "1000";
		List<TieTower> list = tieTowerService.getAllTowers(Integer.parseInt(pageNow), Integer.parseInt(pageSize));
		LogUtils.log(JsonUtilsUseFast.toJson(list));
		JsonUtilsUseFast.jsonToClient(resp, JsonResponseWrapper.getSuccessResponse(list));
	}
	
	@RequestMapping(value = "/admin")
	public String towers(HttpServletRequest req, HttpServletResponse resp,
			Model model) {
		ImagePageInfo pageInfo = tieTowerService.getImageCount();
		model.addAttribute("pageInfo", pageInfo);
		return "tower";
	}
	
	@RequestMapping(value = "/towers2")
	public String towers2(HttpServletRequest req, HttpServletResponse resp,
			Model model) {
		ImagePageInfo pageInfo = tieTowerService.getImageCount();
		model.addAttribute("pageInfo", pageInfo);
		return "tower2";
	}
	
	@RequestMapping(value = "/excel")
	public void excel(HttpServletRequest req, HttpServletResponse resp,
			Model model) throws IOException {
		List<TieTower> list = tieTowerService.getAllTowers(Integer.parseInt(0+""), Integer.parseInt(1000+""));
		String path = ExcelUtils.findePersonList(req, list);
//		 String basePath = req.getScheme() + "://"
//					+ req.getServerName() + ":"
//					+ req.getServerPort() + "/" + req.getContextPath() + "/";
//			 String url = basePath + "resources/upload/" + path;
		
		OutputStream os = resp.getOutputStream();  
		try {  
			resp.reset();  
			String filename = "xx.xls";
			String sdf = new SimpleDateFormat("yyyyMMdd-HH-mm-ss").format(new Date());
			filename = filename.replace("xx", sdf);
			resp.setHeader("Content-Disposition", "attachment; filename={filename}".replace("{filename}", filename));  
			resp.setContentType("application/octet-stream; charset=utf-8");  
	        os.write(FileUtils.readFileToByteArray(new File(path)));  
	        os.flush();  
	    } finally {  
	        if (os != null) {  
	            os.close();  
	        }  
	    }  
	}
	
	@RequestMapping(value = "/deleteAll")
	public String deleteAll(HttpServletRequest req, HttpServletResponse resp,
			Model model) throws IOException {
		tieTowerService.deleteAll();
		return "redirect:/tower/admin";
	}
	
	@RequestMapping(value = "/delete")
	public void deleteById(HttpServletRequest req, HttpServletResponse resp,
			Model model, String id) throws IOException {
		tieTowerService.deleteById(id);
		JsonUtilsUseFast.jsonToClient(resp, JsonResponseWrapper.getSuccessResponse("ok"));
	}
}
