package com.cams.controller;

import com.cams.dao.domain.ActivityType;
import com.cams.dao.domain.Message;
import com.cams.dao.domain.Plcae;
import com.cams.domain.User;
import com.cams.service.PublicService;
import com.cams.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicController {
    @Autowired
    PublicService publicService;

    @PostMapping("/users")
    public Response addUser(@RequestBody User user) {//用户注册
        User ret = publicService.addUsers(user);
        if (ret == null) return Response.errorMsg("注册失败！");
        else return Response.ok(ret);
    }

    @GetMapping("/places")
    public Response seletePlace() {//活动地址查询
        List<Plcae> list = publicService.selectPlace();
        if (list == null) return Response.errorMsg("查询地址列表失败");
        else return Response.ok(list);
    }


    @PutMapping("/users")
    public Response updateUser(@RequestBody User user) {
        User user1 = publicService.updateUser(user);
        if (user1 == null) return Response.errorMsg("信息更新失败");
        else return Response.ok(user1);
    }

    @GetMapping("/activity-types")
    public Response selectActiviytType(@RequestBody ActivityType activityType) {
        List<ActivityType> list = publicService.selectActivityType(activityType);
        if (list.size() > 0) return Response.ok(list);
        else return Response.errorMsg("查询无果");
    }

    @PostMapping("/message")
    public Response addMessage(@RequestBody Message message) {
        int logo = publicService.addMessage(message);
        if (logo == 1) return Response.ok(message);
        else return Response.errorMsg("留言失败");
    }

}
