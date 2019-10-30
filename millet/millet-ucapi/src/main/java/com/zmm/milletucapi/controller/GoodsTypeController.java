package com.zmm.milletucapi.controller;

import com.zmm.milletucapi.common.Response;
import com.zmm.milletucapi.entity.GoodsType;
import com.zmm.milletucapi.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("findAll")
    public Response<GoodsType> findAll(){
        return new Response<GoodsType>(goodsTypeService.findAll());
    }

}
