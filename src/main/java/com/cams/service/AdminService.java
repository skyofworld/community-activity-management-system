package com.cams.service;

import com.cams.dao.domain.*;

import java.util.List;

public interface AdminService {
    List<Admin> selectAdmin(int role);

    List<Sponsor> selectSponsor(int role);

    List<Coach> selectCoach(int role);

    List<Resident> selectResident(int role);


    int throughActivity(int id,int status);//通过活动

    int addPlace(String address,String intro,String img_path);//新建活动地点
}
