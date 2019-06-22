package com.cams.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cams.domain.Resident;
import com.cams.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ResidentMapper extends BaseMapper<Resident> {

    int insertResident(User user);



}