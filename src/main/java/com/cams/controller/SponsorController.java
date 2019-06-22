package com.cams.controller;

import com.cams.dao.domain.Activity;
import com.cams.service.SponsorService;
import com.cams.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class SponsorController {
    @Autowired
    SponsorService sponsorService;



    @PostMapping("")
    public Response addActivity(@RequestBody Activity activity){
        Activity activity1=sponsorService.addActivity(activity);
        if (activity1==null) return Response.errorMsg("活动添加失败");
        else return Response.ok(activity1);
    }


    @PutMapping("")
    public Response updateActivity(@RequestBody Activity activity){
        System.out.println("2");
        int num =sponsorService.updateActivity(activity);
        System.out.println("2");
        if (num==0)return Response.errorMsg("活动更新失败");
        else return Response.ok(activity);

    }

    @GetMapping("")
    public Response selectActivity(@RequestBody Activity activity)  {
        System.out.println(activity.getCoach()+"   "+activity.getSponsor()+" "+activity.getPlace());
        List<Activity> list=sponsorService.selectActivity(activity);
        if (list==null) return Response.errorMsg("查询失败");
        else  return Response.ok(list);
    }

    @DeleteMapping("")
    public Response deleteActivity(@RequestBody Activity activity){
        int log=0;
        int id=activity.getId();
        log=sponsorService.deleteActivity(id);
        System.out.println(log);
        if (log==1)
            return  Response.ok("删除成功");
        else
            return Response.errorMsg("删除失败");

    }

    //xml
    @PutMapping("/set")
    public Response updateActivityxml(@RequestBody Activity activity){
        int num =sponsorService.updateActivity(activity);
        if (num==0)return Response.errorMsg("活动更新失败");
        else return Response.ok("活动更新成功");
    }

    }

