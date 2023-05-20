package com.miao;

import com.miao.utils.JedisConnectionFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class ConnectionTest {
    private Jedis jedis;

    @BeforeEach
    void setUP() {
        //jedis = new Jedis("43.138.194.9", 6379);
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("313725190");
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "张三");
        System.out.println("result=" + result);
        String name = jedis.get("name");
        System.out.println("name=" + name);
    }

    @Test
    void testZRange(){
        Set<String> z1 = jedis.zrange("z1", 0, 100);
        for (String s : z1) {
            System.out.println(s);
        }
    }

    @AfterEach
    void toDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
