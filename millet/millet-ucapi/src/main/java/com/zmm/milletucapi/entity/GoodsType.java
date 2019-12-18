package com.zmm.milletucapi.entity;

import com.zmm.milletucapi.common.BaseEntity;
import com.zmm.milletucapi.utils.DictUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@ApiModel( description = "商品分类表")
@Data
@Table(name = "goods_type")
public class GoodsType extends BaseEntity {
    @ApiModelProperty(value = "商品分类id" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "分类名称" )
    @Column(name = "cat_name")
    private String catName;

    @ApiModelProperty(value = "分类描述" )
    @Column(name = "cat_desc")
    private String catDesc;

    @ApiModelProperty(value = "分类的关键字,可能是为了搜索" )
    private String keywords;

    @ApiModelProperty(value = "该分类的父类ID,取值于该表的id字段" )
    @Column(name = "parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "该分类在页面显示的顺序,数字越大顺序越靠后,同数字,id在前的先显示" )
    @Column(name = "sort_order")
    private Integer sortOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getZdMc(){
        return DictUtil.getValue("sys_zdsj.ZDSJMC",parentId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", catName=").append(catName);
        sb.append(", catDesc=").append(catDesc);
        sb.append(", keywords=").append(keywords);
        sb.append(", parentId=").append(parentId);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append("]");
        return sb.toString();
    }
}