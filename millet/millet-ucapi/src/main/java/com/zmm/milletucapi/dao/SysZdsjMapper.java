package com.zmm.milletucapi.dao;

import com.zmm.milletucapi.entity.SysZdsj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysZdsjMapper extends MyMapper<SysZdsj> {

    List<SysZdsj> getByZdlxId(@Param("zdlxId") Long zdlxId);

}