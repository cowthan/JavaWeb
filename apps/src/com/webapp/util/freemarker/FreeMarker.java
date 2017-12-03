package com.webapp.util.freemarker;

import freemarker.template.*;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class FreeMarker {

    public static String process(String templateFile, Map data){
       return  process(null, "resource/views", templateFile, data);
    }

    public static String process(HttpServlet servlet, String dir, String templateFile, Map data) {

        Configuration cfg = new Configuration();
        StringWriter buf = new StringWriter();
        PrintWriter out = new PrintWriter(buf);
        try {
            // 从哪里加载模板文件
            if(servlet == null){
                cfg.setDirectoryForTemplateLoading(new File(dir));
            }else{
                cfg.setServletContextForTemplateLoading(servlet.getServletContext(), "WEB-INF/ftl");
            }
            cfg.setDefaultEncoding("utf-8");

            // 定义模版的位置，从类路径中，相对于FreemarkerManager所在的路径加载模版
            // cfg.setTemplateLoader(new ClassTemplateLoader(FreemarkerManager.class, "templates"))

            // 设置对象包装器
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            // 设置异常处理器
            cfg .setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

            // 定义数据模型


            // 通过freemarker解释模板，首先需要获得Template对象
            Template template = cfg.getTemplate(templateFile);

            // 定义模板解释完成之后的输出
//            PrintWriter out = new PrintWriter(new BufferedWriter(
//                    new FileWriter(dir+"/out.txt")));


            template.process(data, out);
            String result = buf.getBuffer().toString();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }

}
