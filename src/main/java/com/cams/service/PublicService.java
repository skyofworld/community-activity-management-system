package com.cams.service;

import com.cams.dao.domain.Plcae;
import com.cams.dao.domain.User;

import java.util.List;

public interface PublicService {
    User addUser(User user);

    List<Plcae> selectPlace();

    User updateUser(User user);
}
