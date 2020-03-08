package com.example.community.Provider;

import com.alibaba.fastjson.JSON;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
//access_token:访问令牌
//访问令牌（Access Token）是Windows操作系统用于描述进程或线程安全上下文的一种对象。
//系统使用访问令牌来辨识拥有进程的用户，以及线程试图执行系统任务时是否具有所需的特权

//JSON
//JSON（JavaScript Object Notation，JavaScript对象表示法，读作/ˈdʒeɪsən/）
//是一种由道格拉斯·克罗克福特构想和设计、轻量级的数据交换语言，该语言以易于让人阅读的文字为基础，
//用来传输由属性值或者序列性的值组成的数据对象。json是用来传输数据的字符串，涉及到怎么转成数据并把js转化成JSON字符串用来存取数据
//JSON是一种文本格式 -- 数据类型是文本
//JSON既然是文本格式(什么是文本格式，不用多说吧)，就有这种格式的独特结构,那是一种什么格式呢？
//
//JSON是一种JavaScript Object的文本格式--结构符合JS OBJECT
//JSON的文本格式要符合JavaScript对象的文本格式，JavaScript对象是怎么定义不用说了吧，当然JSON串可以转换成JavaScript对象，怎么操作对象就不废话了。那这种文本格式是干什么用的？
//
//JSON是一种用来交换数据的JavaScript Object文本格式 -- 用在数据交换
//JSON的作用就是交换数据啊，也就是说你要发送和接收的数据都是放在JSON中的。当你发送端和接收端需要做数据通信，JSON是不错的选择，当然你可以选择其他的数据交换格式。
//
//JSON是一种轻量级的用来交换数据的JavaScript Object文本格式 -- 优点：轻量
//数据交换文本格式那么多，JSON和其他数据交换格式相比是轻量级(什么是轻量级，这里不说)的，和其他的同类不是一个级别的，这样的优点，你不选我，那你选谁。


@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);//把string的json的对象自动转换解析成java的类对象
            return githubUser;
        } catch (IOException e) {
        }
        return null;
        }
}
