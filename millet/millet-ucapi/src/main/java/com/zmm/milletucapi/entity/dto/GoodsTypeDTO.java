package com.zmm.milletucapi.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zmm.milletucapi.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ApiModel( description = "商品分类表")
@Data
@ToString
public class GoodsTypeDTO extends BaseEntity {
    @ApiModelProperty(value = "表头" )
    private List<String> monthHeader;

    @ApiModelProperty(value = "收入类" )
    private String catName;

    @ApiModelProperty(value = "支出类" )
    private String catDesc;

    @ApiModelProperty(value = "分类的关键字,可能是为了搜索" )
    private String keywords;

    @ApiModelProperty(value = "该分类的父类ID,取值于该表的id字段" )
    private Integer parentId;

    @ApiModelProperty(value = "该分类在页面显示的顺序,数字越大顺序越靠后,同数字,id在前的先显示" )
    private Integer sortOrder;

}