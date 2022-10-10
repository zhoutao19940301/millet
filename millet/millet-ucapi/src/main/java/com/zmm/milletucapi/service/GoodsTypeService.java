package com.zmm.milletucapi.service;

import com.zmm.milletucapi.aspect.MyLogAnnotation;
import com.zmm.milletucapi.dao.GoodsTypeMapper;
import com.zmm.milletucapi.entity.GoodsType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @MyLogAnnotation
    public List<GoodsType> findAll(){
        List<GoodsType> list = goodsTypeMapper.findAllGoods();
        return list;
    }

    public void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        ListOperations listOperations = redisTemplate.opsForList();
        HashOperations hashOperations = redisTemplate.opsForHash();
        SetOperations setOperations = redisTemplate.opsForSet();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

    }

}
