package com.zmm.milletucapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value="商品分类controller",tags={"商品分类操作接口"})
@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @GetMapping("/getAllType")
    @ApiOperation(value = "获取所有分类大类")
    public String userLogin(){
        return "hehe";
    }
}
