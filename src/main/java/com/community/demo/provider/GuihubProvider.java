package com.community.demo.provider;

import com.alibaba.fastjson.JSON;
import com.community.demo.dto.GithubUser;
import okhttp3.*;

import java.io.IOException;
import com.community.demo.dto.AcessTokenDTO;
import org.springframework.stereotype.Component;

@Component
public class GuihubProvider {
    public String getAccessToken(AcessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            System.out.println("body:"+JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                System.out.println(string);
                String[] split = string.split("&");
                String tokenstr = split[0];
                String token = tokenstr.split("=")[1];
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }


    public GithubUser getUserMessage(String acessTokenDTO){
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("https://api.github.com/user?access_token="+acessTokenDTO)
//                .build();
//        try  {
//            Response response = client.newCall(request).execute();
//            String string = response.body().string();
//            GithubUser githubUser=JSON.parseObject(string,GithubUser.class);
//            return githubUser;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
        GithubUser githubUser = new GithubUser();
        githubUser.setId((long) 35244100);
        githubUser.setName("Little DM");
        githubUser.setBio(null);
        githubUser.setAvatar_url("https://avatars1.githubusercontent.com/u/35244100?v=4");
        return githubUser;
    }
}
