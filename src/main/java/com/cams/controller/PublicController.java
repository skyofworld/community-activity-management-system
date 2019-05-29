package com.cams.controller;

import com.cams.dao.domain.Plcae;
import com.cams.dao.domain.User;
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
        User ret = publicService.addUser(user);
        if (ret == null) return Response.errorMsg("注册失败！");
        else return Response.ok(ret);
    }

    @GetMapping("/place")
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

}
