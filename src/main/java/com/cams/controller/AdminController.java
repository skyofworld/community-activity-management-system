package com.cams.controller;

import com.cams.dao.domain.*;
import com.cams.domain.Resident;
import com.cams.domain.User;
import com.cams.service.AdminService;
import com.cams.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("")
    public Response selectUser(@RequestBody User user){
        int role=user.getRole();
        if (role==1){
            List<Admin> list=adminService.selectAdmin(role);
            if (list==null) return Response.errorMsg("管理员信息查询失败");
            else  return  Response.ok(list);
        }
        if (role==2){
            List<Sponsor> list=adminService.selectSponsor(role);
           if (list==null) return Response.errorMsg("发起者信息查询失败");
           else  return  Response.ok(list);
        }
        if (role==3){
            List<Coach> list=adminService.selectCoach(role);
            if (list==null) return Response.errorMsg("导师信息查询失败");
            else  return  Response.ok(list);
        }
        if (role==4){
            List<Resident> list=adminService.selectResident(role);
            if (list==null) return Response.errorMsg("活动参与者信息查询失败");
            else  return  Response.ok(list);
        }

        return  Response.errorMsg("查询失败");


    }
    @PutMapping("")//更新活动信息
    public  Response througtActivity(@RequestBody Activity activity){
        int id=activity.getId();
        int status=activity.getStatus();
        int logo=adminService.throughActivity(id,status);
        if (logo==1) return  Response.ok("更新成功");
        else return Response.errorMsg("更新失败");
    }

    @PostMapping("/place")//新建活动地点
    public Response addPlace(@RequestBody Plcae plcae){
        int logo=0;
        logo=adminService.addPlace(plcae);
        if (logo==1) return Response.ok("新建地点成功");
        else  return Response.errorMsg("新建地点失败");
    }


}
