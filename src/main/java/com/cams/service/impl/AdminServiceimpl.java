package com.cams.service.impl;

import com.cams.dao.domain.*;
import com.cams.dao.mapper.AdminMapper;
import com.cams.domain.Resident;
import com.cams.domain.User;
import com.cams.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cams.utils.VALUE.*;

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
    public int addPlace(Plcae plcae) {
        int logo=adminMapper.addplace(plcae);
        if (logo==1) return 1;
        else  return -1;
    }

    @Override
    public int addPlaceType(ActivityType activityType) {
        int logo=adminMapper.addplacetype(activityType);
        if (logo==1) return 1;
        else return  0;
    }

    @Override
    public List<Message> getMessages() {
        List<Message> list=adminMapper.getMessages();
        if (list.size()>0) return list;
        else return null;

    }

    @Override
    public User updateStste(User user) {
        int role=user.getRole();
        int logo=0;
        switch (role){
            case ROLE_ADMIN:
               logo=adminMapper.updateAdmin(user);
                break;
            case ROLE_SPONSOR:
                logo=adminMapper.updateSoponsor(user);
                break;
            case ROLE_COACH:
                logo=adminMapper.updateCoach(user);
                break;
            case ROLE_RESIDENT:
                logo=adminMapper.updateResident(user);
        }
        if (logo==1) return  user;
        else  return null;
    }
}
