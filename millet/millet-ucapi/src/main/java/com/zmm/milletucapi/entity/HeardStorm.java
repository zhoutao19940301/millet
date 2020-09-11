package com.zmm.milletucapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel( description = "")
@Data
@ToString
@Table(name = "heard_storm")
public class HeardStorm implements Serializable {
    @ApiModelProperty(value = "" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "图片路径" )
    private String path;

    @ApiModelProperty(value = "" )
    private String answers;

    @ApiModelProperty(value = "" )
    private String remark;

    @ApiModelProperty(value = "是否已用过，0没用过，1已经用过" )
    @Column(name = "is_used")
    private Integer isUsed;

    @ApiModelProperty(value = "更新时间" )
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}