package com.cams.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.cams.dao.domain.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface SponsorMapper  extends BaseMapper<Activity> {


    @Override
    int deleteById(Serializable id);

    @Override
    int insert(Activity entity);
//
    @Override
    List<Activity> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
//    @Param("et")
    @Override
    int updateById(@Param(Constants.ENTITY) Activity entity);//必须输入所有外键属性


    //xml方法
    int updateActivity(Activity activity);//必须输入所有外键属性
}