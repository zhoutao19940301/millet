package com.zmm.milletucapi.service;

import com.zmm.milletucapi.dao.GoodsTypeMapper;
import com.zmm.milletucapi.entity.GoodsType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    public List<GoodsType> findAll(){
        List<GoodsType> list = goodsTypeMapper.findAllGoods();
        return list;
    }

}
