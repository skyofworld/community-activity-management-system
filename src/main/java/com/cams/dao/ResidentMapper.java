package com.cams.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cams.domain.Resident;
import com.cams.domain.User;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ResidentMapper extends BaseMapper<Resident> {
    int insertResident(User user);



}