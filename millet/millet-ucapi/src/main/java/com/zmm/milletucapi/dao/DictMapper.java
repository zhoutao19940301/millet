package com.zmm.milletucapi.dao;

import com.zmm.milletucapi.entity.Dict;
import java.util.List;

public interface DictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dict record);

    Dict selectByPrimaryKey(Integer id);

    List<Dict> selectAll();

    int updateByPrimaryKey(Dict record);
}