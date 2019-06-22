package com.cams.service;

import com.cams.dao.domain.*;
import com.cams.domain.Resident;
import com.cams.domain.User;

import java.util.List;

public interface AdminService {
    List<Admin> selectAdmin(int role);

    List<Sponsor> selectSponsor(int role);

    List<Coach> selectCoach(int role);

    List<Resident> selectResident(int role);


    int throughActivity(int id,int status);//通过活动

    int addPlace(Plcae plcae);//新建活动地点

    int addPlaceType(ActivityType activityType);

    List<Message> getMessages();//获得信息

    User updateStste(User user);//更改用户状态
}
