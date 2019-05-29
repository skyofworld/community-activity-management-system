package com.cams.service.impl;

import com.cams.dao.domain.*;
import com.cams.dao.mapper.AdminMapper;
import com.cams.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceimpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Sponsor> selectSponsor(int role) {
        List<Sponsor> list=null;
        list=adminMapper.selectSponsor(role);
        if (list==null) return null;
        else  return list;
    }

    @Override
    public List<Admin> selectAdmin(int role) {
        List<Admin> list=null;
        list=adminMapper.selectAdmin(role);
        if (list==null) return null;
        else  return list;
    }

    @Override
    public List<Coach> selectCoach(int role) {
        List<Coach> list=null;
        list=adminMapper.selectCoach(role);
        if (list==null) return null;
        else  return list;
    }

    @Override
    public List<Resident> selectResident(int role) {
        List<Resident> list=null;
        list=adminMapper.selectResident(role);
        if (list==null) return null;
        else  return list;
    }

    @Override
    public int throughActivity(int id, int status) {
        int logo=0;
        logo=adminMapper.throughActivity(id,status);
        if (logo==1) return logo;
        else return -1;
    }

    @Override
    public int addPlace(String address, String intro, String img_path) {
        int logo=adminMapper.addplace(address,intro,img_path);
        if (logo==1) return 1;
        else  return -1;
    }
}
