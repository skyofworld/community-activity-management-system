package com.cams.dao;

import com.cams.BaseTest;
import com.cams.domain.User;
import com.cams.service.impl.RedisHelperImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisTest extends BaseTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisHelperImpl redisHelper;

    @Test
    public void test() throws Exception{
//        基本写法
//        stringRedisTemplate.opsForValue().set("aaa","111");
//        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
//        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        User user=new User();
        user.setName("Alex");
        redisHelper.valuePut("aaa",user);
        System.out.println(redisHelper.getValue("aaa"));
    }

    @Ignore
    public void testObj() throws Exception {
        User user=new User();
        user.setName("Jerry");

        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("502", user);
        Thread.sleep(500);
        boolean exists=redisTemplate.hasKey("502");
        if(exists){
            System.out.println(redisTemplate.opsForValue().get("502"));
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
