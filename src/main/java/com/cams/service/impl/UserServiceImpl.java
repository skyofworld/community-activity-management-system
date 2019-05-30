package com.cams.service.impl;

<<<<<<< HEAD
import com.cams.dao.domain.User;
import com.cams.dao.mapper.ResidentMapper;
=======
import com.cams.domain.User;
import com.cams.dao.ResidentMapper;
>>>>>>> 032ddff9d1a14ee5081f03b759bf56bca23ad696
import com.cams.service.UserService;
import com.cams.utils.VALUE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ResidentMapper residentMapper;

    @Override
    public User addUser(User user) {
        int lines = 0;
        switch (user.getRole()) {
            case VALUE.ROLE_ADMIN:
                lines = 0;
                break;
            case VALUE.ROLE_SPONSOR:
                lines = 0;
                break;
            case VALUE.ROLE_COACH:
                lines = 0;
                break;
            case VALUE.ROLE_RESIDENT:
                lines = residentMapper.insertResident(user);
                default: break;
        }
        if (lines == 0) return null;
        else return user;
    }




}
