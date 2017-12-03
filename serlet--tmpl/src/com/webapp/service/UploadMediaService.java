package com.webapp.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.webapp.dao.DaoFactory;
import com.webapp.dao.MediaDao;
import com.webapp.entity.Media;

public class UploadMediaService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MediaDao mediaDao = DaoFactory.getMediaDao();
		String message = "";

		String uri = request.getRequestURI();
		System.out.println("uri>>"+uri);
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));

		if ("/uploadFile".equals(path)) {
			// �ṩ����ʱ��һЩȱʡ����
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// ����һ��������,����InputStream,�ý������Ὣ�����Ľ����װ��һ��FileItem����ļ���
			// һ��FileItem�����Ӧһ������
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				Media media = new Media();
				List<FileItem> items = sfu.parseRequest(request);
				boolean flag = false; // ת��ɹ����ı��
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
					if (item.isFormField()) {
						//普通表单x
						String fieldName = item.getFieldName();//获取元素名称
						String value = item.getString("UTF-8"); //获取元素值
						System.out.println(fieldName+" : "+value);
						 
						if (fieldName.equals("title")) {
							media.setTitle(value);
						}
						if (fieldName.equals("descript")) {
							media.setDescript(value);
						}

					} else {
						//文件上传表单
						ServletContext sctx = this.getServletContext();
						String basePath = sctx.getRealPath("/upload");
						String fileUrl = item.getName();
						String fileType = fileUrl.substring(fileUrl
								.lastIndexOf("."));
						System.out.println("上传文件：" + fileUrl + "， " + fileType);

						String serialName = String.valueOf(System.currentTimeMillis());
						File uploadFile = new File(basePath + "/temp/" + serialName + fileType);

						File dir = new File(basePath + "/temp");
						if(!dir.exists() || !dir.isDirectory()){
							dir.mkdirs();
						}

						dir = new File(basePath + "/images");
						if(!dir.exists() || !dir.isDirectory()){
							dir.mkdirs();
						}

						if(uploadFile.createNewFile()){

						}else{
							System.out.println("无法创建文件：" + uploadFile.getAbsolutePath());
							message = "<li>无法创建文件：" + uploadFile.getAbsolutePath() + "</li>";
						}

						item.write(uploadFile);

						if (item.getSize() > 500 * 1024 * 1024) {
							message = "<li>�ϴ�ʧ�ܣ����ϴ����ļ�̫��,ϵͳ��������ļ�500M</li>";
						}


						if(1 + 1 == 2){
							media.setSrc("upload/temp/" + serialName + fileType);
							media.setPicture("upload/images/" + "ic_qr" + ".jpeg");
							String now = System.currentTimeMillis()+"";
							media.setUptime(now);
							flag = true;
						}else{
							String codcFilePath = basePath + "/" + serialName
									+ ".flv";
							String mediaPicPath = basePath + "/images"
									+ File.separator + serialName + ".jpg";

							String ffmpegPath = getServletContext().getRealPath(
									"/tools/ffmpeg.exe");

							media.setSrc("upload/" + serialName + ".flv");
							media.setPicture("upload/images/" + serialName + ".jpg");
							String now = System.currentTimeMillis()+"";
							media.setUptime(now);

							flag = mediaDao.executeCodecs(ffmpegPath,
									uploadFile.getAbsolutePath(), codcFilePath,
									mediaPicPath);
						}



						// ת��

					}
				}


				media.setTitle("无");
				media.setDescript("无");
				if (flag) {
					// ת��ɹ�,�����ݱ�����Ӹ���Ƶ��Ϣ
					mediaDao.saveMedia(media);
					message = "<li>�ϴ��ɹ�!</li>";
				}

				request.setAttribute("message", message);
				request.getRequestDispatcher("media_upload.jsp").forward(
						request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}

		if ("/queryAll".equals(path)) {
			List<Media> mediaList;
			try {
				mediaList = mediaDao.queryALlMedia(0, 6);
				request.setAttribute("mediaList", mediaList);
				request.getRequestDispatcher("media_list.jsp").forward(request,
						response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ("/play".equals(path)) {
			String idstr = request.getParameter("id");
			int mediaId = -1;
			Media media = null;
			if (null != idstr) {
				mediaId = Integer.parseInt(idstr);
			}
			try {
				media = mediaDao.queryMediaById(mediaId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("media", media);
			request.getRequestDispatcher("media_player.jsp").forward(request,
					response);
		}
	}

}
