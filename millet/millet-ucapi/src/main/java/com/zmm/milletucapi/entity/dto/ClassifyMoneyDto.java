package com.zmm.milletucapi.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 履约监控平台-合同总览实体
 * @author zhoutao21342@talkweb.com.cn
 * @date 2022/8/22
 * @apiNote
 */
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassifyMoneyDto {

    /**
     * 合同分类。1:收入类  2：支出类
     */
    private int type;

    /**
     * 月份
     */
    private String month;

    /**
     * 金额
     */
    private Double money;

}
