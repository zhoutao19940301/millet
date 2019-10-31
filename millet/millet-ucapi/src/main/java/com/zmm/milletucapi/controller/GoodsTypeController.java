package com.zmm.milletucapi.controller;

import com.github.pagehelper.PageHelper;
import com.zmm.milletucapi.common.Response;
import com.zmm.milletucapi.entity.GoodsType;
import com.zmm.milletucapi.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("findAll")
    public Response<GoodsType> findAll(){
//        PageHelper.offsetPage(1,10);分页示例
        List<GoodsType> list = goodsTypeService.findAll();
        return new Response<GoodsType>(list);
    }

}
