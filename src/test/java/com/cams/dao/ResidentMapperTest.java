package com.cams.dao;

import com.cams.BaseTest;
import com.cams.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ResidentMapperTest extends BaseTest {
    @Autowired
    private ResidentMapper residentMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        User user = new User();
        user.setName("ray");
        user.setRole(4);
        user.setPassword("123");
        residentMapper.insertResident(user);
        System.out.println(user.getId());
    }
}