package okhttp3.guide;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetExample {
  OkHttpClient client = new OkHttpClient();

  String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = client.newCall(request).execute();
    return response.body().string();
  }

  public static void main1(String[] args) throws IOException {
    GetExample example = new GetExample();
    String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
    System.out.println(response);
  }
  
  public static void main(String[] args) throws IOException {
	
	  
	  OkHttpClient client = new OkHttpClient();

	  
	  Request request = new Request.Builder()
      .url("http://api.zhigu.bjzzcb.com/v1/zArticle/info?id=13204")
      .header("deviceid", "358108067277979")
      .header("os", "android")
      .header("version", "2.2.1")
      .build();

	  Response response = client.newCall(request).execute();
	  System.out.println(response.body().string());
  }
}
