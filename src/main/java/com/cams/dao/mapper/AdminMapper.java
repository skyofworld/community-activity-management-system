package com.cams.dao.mapper;

import com.cams.dao.domain.*;
import com.cams.domain.Resident;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface AdminMapper {
    //用户查询
    @Select("select * from admin where role=#{role}")
    List<Admin> selectAdmin(int role);

    @Select("select * from sponsor where role=#{role}")
    List<Sponsor> selectSponsor(int role);

    @Select("select * from coach where role=#{role}")
    List<Coach> selectCoach(int role);

    @Select("select * from resident where role=#{role}")
    List<Resident> selectResident(int role);

    //通过活动
    @Update("update activity set status=#{status} where id=#{id}")
    int throughActivity(int id,int status);

   //新建活动地点
    @Insert("insert into place (address,intro,img_path,num) values(#{address},#{intro},#{img_path},#{num)")
    int addplace(Plcae plcae);

    //新建活动类型
    @Insert(("insert into activity_type (name,credit,intro,img_path)values(#{name),#{credit},#{intro},#{imgPath}"))
    int addplacetype(ActivityType activityType);

}
