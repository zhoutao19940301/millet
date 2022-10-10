package com.zmm.milletucapi.controller;

import com.zmm.milletucapi.common.Response;
import com.zmm.milletucapi.entity.GoodsType;
import com.zmm.milletucapi.entity.vo.QueryScopeVo;
import com.zmm.milletucapi.service.GoodsTypeService;
import com.zmm.milletucapi.utils.EasyExcelExportUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
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
