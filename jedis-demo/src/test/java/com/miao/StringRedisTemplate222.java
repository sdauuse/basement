package com.miao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class StringRedisTemplate222 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString() {
        // 写入一条String数据
        stringRedisTemplate.opsForValue().set("s1", "虎哥");
        // 获取string数据
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "lky");
        map.put("age", "18");
    }
}
