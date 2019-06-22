package com.cams.controller;

//<<<<<<< HEAD
import com.cams.service.UserService;
//=======
import com.cams.domain.User;
import com.cams.domain.WXSession;
import com.cams.service.RedisHelper;
//import com.cams.service.UserService;
import com.cams.utils.HttpClient;
import com.cams.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
//>>>>>>> 032ddff9d1a14ee5081f03b759bf56bca23ad696
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisHelper redisHelper;

    @PostMapping("/login")
    public Response login(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> params = new HashMap<>();
        params.put("appid", "wxdeba155ff0178d29");
        params.put("secret", "b88c6f6052d45dd033ec3365547d22ac");
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        String wxResult = HttpClient.doGet(url, params);
        WXSession session;
        try {
            session = new ObjectMapper().readValue(wxResult, WXSession.class);
        } catch (IOException e) {
            return Response.errorMsg(e.getMessage());
        }
        String openid = session.getOpenid();
        String key = "session-"+openid;
        redisHelper.valuePut(key, session.getSession_key());
        redisHelper.expirse(key, 1, TimeUnit.HOURS);
        User user = new User();
        user.setOpenid(openid);
        return Response.ok(user);
    }

//    @PostMapping("")
//    public Response addUser(@RequestBody User user) {
//        User ret = userService.addUser(user);
//        if (ret == null) return Response.errorMsg("注册失败！");
//        else return Response.ok(ret);
//    }



    }


