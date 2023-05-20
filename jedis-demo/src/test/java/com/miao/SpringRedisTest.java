package com.miao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class SpringRedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void testString() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("s1", "虎哥");
        // 获取string数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }
}
