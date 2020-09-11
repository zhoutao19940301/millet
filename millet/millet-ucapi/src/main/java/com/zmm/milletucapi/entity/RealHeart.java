package com.zmm.milletucapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel( description = "")
@Data
@ToString
@Table(name = "real_heart")
public class RealHeart implements Serializable {
    @ApiModelProperty(value = "" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "" )
    private String content;

    @ApiModelProperty(value = "是否已用过，0没用过，1已经用过" )
    @Column(name = "is_used")
    private Integer isUsed;

    private static final long serialVersionUID = 1L;
}