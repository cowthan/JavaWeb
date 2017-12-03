package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 廖师兄
 * 2017-07-03 00:50
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
//不使用第三方微信sdk的做法，留作测试用
/*
用户通过微信打开：
https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa6eb5377af85e9b8&redirect_uri=http://zebdar.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
就会请求这个接口，这个就是网页授权接口
 */
public class WeixinController {

    //http://zebdar.natapp1.cc/sell/weixin/auth?code=dd
    //微信的回调地址，获取code
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxa6eb5377af85e9b8&secret=89eae9fdd2af767bd61fc21659320ae0&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        //response的值：{"access_token":"RJmBc-xHpCnAJnNQC-VfZ45xDNcB0MpRq5iHhOsW8jlFFuUaFF46avlakKqg06jJf7maQNZsoDZlQs1Rh2-MmA","expires_in":7200,"refresh_token":"_LdWWkOXzfPUH4hC5stw4Fa50PSnU_nh6z1rOEOsufeww2mUIKGHfzZyzc3r1bN1_5Eg4VgR3tCs0uBUwwd2Hw","openid":"oyqQK1SaIW32Wjc25djrFp1XqoQY","scope":"snsapi_base"}

        // 要的就是openid：oyqQK1SaIW32Wjc25djrFp1XqoQY  用于支付
    }
}
