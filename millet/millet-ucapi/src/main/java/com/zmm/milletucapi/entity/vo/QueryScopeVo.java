package com.zmm.milletucapi.entity.vo;

import lombok.Data;

/**
 * QueryScopeVo
 *
 * @author zhoutao21342@talkweb.com.cn
 * @date 2022/8/22
 * @apiNote 查询范围（省份，公司，部门）
 */
@Data
public class QueryScopeVo {

    private static final long serialVersionUID = 1L;

    /**
     * 省份id
     */
    private Long provinceId;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 承办部门id
     */
    private Long deptId;

}
