package com.zmm.milletucapi.dao;

import com.zmm.milletucapi.common.MyMapper;
import com.zmm.milletucapi.entity.GoodsType;
import com.zmm.milletucapi.entity.dto.ClassifyMoneyDto;
import com.zmm.milletucapi.entity.dto.ExpendMoneyDto;
import com.zmm.milletucapi.entity.vo.QueryScopeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsTypeMapper extends MyMapper<GoodsType> {

    List<GoodsType> findAllGoods();

    /**
     * 业务名称
     * @author zhoutao21342@talkweb.com.cn
     * @apiNote 逻辑描述
     * @date 2022/8/24
     * @param: queryScopeVo
     * @return: java.util.List<com.zmm.milletucapi.entity.dto.ClassifyMoneyDto>
     **/
    List<ClassifyMoneyDto> getContractMoneyByClassify(QueryScopeVo queryScopeVo);

    /**
     * 合同总览-按支出统计
     * @author zhoutao21342@talkweb.com.cn
     * @apiNote 按支出类型统计支出金额
     * @date 2022/8/23
     * @param: queryScopeVo
     * @return: java.util.List<com.chinaunicom.ecm.perform.monitor.entity.dto.ExpendMoneyDto>
     **/
    List<ExpendMoneyDto> getContractMoneyByExpend(QueryScopeVo queryScopeVo);

}