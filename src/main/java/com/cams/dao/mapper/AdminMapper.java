package com.cams.dao.mapper;

import com.cams.dao.domain.Admin;
import com.cams.dao.domain.Coach;
import com.cams.dao.domain.Resident;
import com.cams.dao.domain.Sponsor;
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

//    新建活动地点
    @Insert("insert into place (address,intro,img_path) values(#{address},#{intro},#{img_path})")
    int addplace(String address,String intro,String img_path);

//    int addplacetype(At)

}
