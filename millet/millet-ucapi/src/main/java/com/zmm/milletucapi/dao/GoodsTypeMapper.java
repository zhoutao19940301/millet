package com.zmm.milletucapi.dao;

import com.zmm.milletucapi.common.MyMapper;
import com.zmm.milletucapi.entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsTypeMapper extends MyMapper<GoodsType> {

    List<GoodsType> findAllGoods();

}