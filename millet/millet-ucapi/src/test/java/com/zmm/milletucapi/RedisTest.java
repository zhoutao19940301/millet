package com.zmm.milletucapi;

import com.zmm.milletucapi.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/12/18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtils redisUtils;

    /**
     * 插入缓存数据
     */
    @Test
    public void set() {
        redisUtils.set("redis_key1", "redis_val1e1");
    }

    /**
     * 读取缓存数据
     */
    @Test
    public void get() {
        Object value = redisUtils.get("redis_key2");
        System.out.println(value);
    }

    @Test
    public void delete() {
        redisUtils.delete("redis_key");
    }

}
