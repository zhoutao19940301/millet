package com.zmm.milletucapi.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 履约监控平台-合同总览支出类实体
 * @author zhoutao21342@talkweb.com.cn
 * @date 2022/8/23
 * @apiNote
 */
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpendMoneyDto {

    /**
     * 支出类名称
     */
    private String typeName;

    /**
     * 金额
     */
    private Double money;

}
