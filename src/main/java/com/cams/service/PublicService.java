package com.cams.service;

import com.cams.dao.domain.ActivityType;
import com.cams.dao.domain.Message;
import com.cams.dao.domain.Plcae;
import com.cams.domain.User;

import java.util.List;

public interface PublicService {
    User addUsers(User user);

    List<Plcae> selectPlace();

    User updateUser(User user);

    List<ActivityType> selectActivityType(ActivityType activityType);

    int addMessage(Message message);
}
