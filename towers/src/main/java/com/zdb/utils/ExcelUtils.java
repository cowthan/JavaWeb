package com.zdb.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.zdb.bean.TieTower;


public class ExcelUtils {
	
	/**
	 * 导出excel
	 */
	@SuppressWarnings("deprecation")
	public static String findePersonList(HttpServletRequest req, List<TieTower> list) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("信息表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		//运营商 区县 人员 站名 发电机型号 发电流程 时间 经度 纬度 地理位置
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("运营商");
		cell.setCellStyle(style);

		cell = row.createCell((short) 1);
		cell.setCellValue("区县");
		cell.setCellStyle(style);

		cell = row.createCell((short) 2);
		cell.setCellValue("人员");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 3);
		cell.setCellValue("站名 ");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 4);
		cell.setCellValue("发电机型号");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 5);
		cell.setCellValue("发电流程");
		cell.setCellStyle(style);

		cell = row.createCell((short) 6);
		cell.setCellValue("时间");
		cell.setCellStyle(style);

		cell = row.createCell((short) 7);
		cell.setCellValue("经度");
		cell.setCellStyle(style);

		cell = row.createCell((short) 8);
		cell.setCellValue("纬度");
		cell.setCellStyle(style);


		cell = row.createCell((short) 9);
		cell.setCellValue("地理位置");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 10);
		cell.setCellValue("图片");
		cell.setCellStyle(style);
		
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getName()+"--"+list.get(i).getSex()+"-"+list.get(i).getAge()+"--"+list.get(i).getCdate());
			row = sheet.createRow((int) i + 1);
			
			//0运营商 1区县 2人员 3站名 4发电机型号 5发电流程 6时间 7经度 8纬度 9地理位置
			row.createCell((short) 0).setCellValue(list.get(i).getGongsi());
			row.createCell((short) 1).setCellValue(list.get(i).getCity());
			row.createCell((short) 2).setCellValue(list.get(i).getName());
			row.createCell((short) 3).setCellValue(list.get(i).getStateName());
			row.createCell((short) 4).setCellValue(list.get(i).getMotorType());
			row.createCell((short) 5).setCellValue(list.get(i).getStatus());
			row.createCell((short) 6).setCellValue(list.get(i).calculateTime());
			row.createCell((short) 7).setCellValue(list.get(i).getLnt());
			row.createCell((short) 8).setCellValue(list.get(i).getLat());
			row.createCell((short) 9).setCellValue(list.get(i).getAddr());
			
//			row.createCell((short) 4).setCellValue(list.get(i).photo);
			
//			HSSFHyperlink h = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
//			h.setAddress(list.get(i).photo);
//			h.setLabel("图片链接");
//			h.setTextMark("图片链接");
//			h.setShortFilename("图片链接");
//			row.createCell((short) 4).setHyperlink(h);
//			row.createCell((short) 4).setCellValue(new HSSFRichTextString("点击观看图片"));;
		}
		// 第六步，将文件存到指定位置
		String fname = System.currentTimeMillis() + ".xls";
		File outFile = new File(getUploadDir(req) + fname);
		try {
//			String basePath = req.getScheme() + "://"
//					+ req.getServerName() + ":"
//					+ req.getServerPort() + "/" + req.getContextPath() + "/";
//			FileOutputStream fout = new FileOutputStream("J:/tietaInfo.xls");
			FileOutputStream fout = new FileOutputStream(outFile.getAbsoluteFile());
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 String basePath = req.getScheme() + "://"
//				+ req.getServerName() + ":"
//				+ req.getServerPort() + "/" + req.getContextPath() + "/";
//		 String url = basePath + "resources/upload/" + fname;
		 System.out.println(outFile.getAbsolutePath());
		 return outFile.getAbsolutePath();
	}
	
	private static String getUploadDir(HttpServletRequest req){
//		String uploadDir = (req.getSession().getServletContext()
//				.getRealPath("/") + "resources/upload/").replace("\\", "/");
		String uploadDir = req.getSession().getServletContext().getRealPath("upload");
		return uploadDir;
	}
}
