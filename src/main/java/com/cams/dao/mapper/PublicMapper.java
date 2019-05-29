package com.cams.dao.mapper;

import com.cams.dao.domain.Plcae;
import com.cams.dao.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PublicMapper  {
    @Insert("insert into resident (id,name,role,gender,identity_Card,phone,email,intro,img_Path,salt,password)values(#{id},#{name},#{role},#{gender},#{identityCard},#{phone},#{email},#{intro},#{imgPath},#{salt},#{password} )")
    int addResident(User user);//用户注册

    @Insert("insert into coach (id,name,role,gender,identity_Card,phone,email,intro,img_Path,salt,password)values(#{id},#{name},#{role},#{gender},#{identityCard},#{phone},#{email},#{intro},#{imgPath},#{salt},#{password} )")
    int addCoach(User user);//导师注册

    @Insert("insert into sponsor (id,name,role,gender,identity_Card,phone,email,intro,img_Path,salt,password)values(#{id},#{name},#{role},#{gender},#{identityCard},#{phone},#{email},#{intro},#{imgPath},#{salt},#{password} )")
    int addsponsor(User user);//发起者注册

    @Insert("insert into admin (id,name,role,gender,identity_Card,phone,email,img_Path,salt,password)values(#{id},#{name},#{role},#{gender},#{identityCard},#{phone},#{email},#{imgPath},#{salt},#{password} )")
    int addadmin(User user);//管理员注册

    @Select("select * from place ")
    List<Plcae> selectPlace();//地址查询


    //更新信息必须输入属性【id，role，name，passowrd】
    @Update("update resident set name=#{name},gender=#{gender},identity_card=#{identityCard},phone=#{phone},email=#{email},intro=#{intro},img_path=#{imgPath},password=#{password} where id=#{id}")
    int updateResident(User user);//用户信息编译

    @Update("update coach set name=#{name},gender=#{gender},identity_card=#{identityCard},phone=#{phone},email=#{email},intro=#{intro},img_path=#{imgPath},password=#{password} where id=#{id}")
    int updateCoach(User user);//发起者信息编译

    @Update("update sponsor set name=#{name},gender=#{gender},identity_card=#{identityCard},phone=#{phone},email=#{email},intro=#{intro},img_path=#{imgPath},password=#{password} where id=#{id}")
    int updateSponsor(User user);//导师信息编译

    @Update("update admin set name=#{name},gender=#{gender},identity_card=#{identityCard},phone=#{phone},email=#{email},intro=#{intro},img_path=#{imgPath},password=#{password} where id=#{id}")
    int updateAdmin(User user);//管理员信息编译


}
