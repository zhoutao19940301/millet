package com.zmm.milletucapi.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zmm.milletucapi.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@ApiModel( description = "商品分类表")
@Data
@ToString
@Table(name = "goods_type")
@EqualsAndHashCode
public class GoodsType extends BaseEntity {
    @ApiModelProperty(value = "商品分类id" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(value = {"统计","商品分类id"}, index = 0)
    private Integer id;

    @ApiModelProperty(value = "分类名称" )
    @Column(name = "cat_name")
    @ExcelProperty(value = {"统计","分类名称"}, index = 1)
    private String catName;

    @ApiModelProperty(value = "分类描述" )
    @Column(name = "cat_desc")
    @ExcelProperty(value = {"统计","分类描述"}, index = 2)
    private String catDesc;

    @ApiModelProperty(value = "分类的关键字,可能是为了搜索" )
    private String keywords;

    @ApiModelProperty(value = "该分类的父类ID,取值于该表的id字段" )
    @Column(name = "parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "该分类在页面显示的顺序,数字越大顺序越靠后,同数字,id在前的先显示" )
    @Column(name = "sort_order")
    private Integer sortOrder;

}