package com.zmm.milletucapi.controller;

import com.zmm.milletucapi.common.ParamException;
import com.zmm.milletucapi.common.Response;
import com.zmm.milletucapi.common.TkResponseCode;
import com.zmm.milletucapi.entity.RealHeart;
import com.zmm.milletucapi.service.RealHeartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

/**
* @Descriprion RealHeart控制层
* @Author  bigdata
* @Date  2020-05-22 16:32:36
*/
@Api(tags = "RealHeart管理")
@RestController
@RequestMapping("/realHeart")
@Slf4j
@Validated
public class RealHeartController {

    @Resource
    private RealHeartService realHeartService;

    @PostMapping("/update")
    @ApiOperation(value = "更新", notes = "更新")
    public Response updateRealHeart(@Valid @RequestBody RealHeart req){
        Response response = null;
        try {
            realHeartService.updateById(req);
            response = new Response();
        } catch (ParamException e) {
            log.error(e.getMessage(),e);
            response = new Response(e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            response = new Response(TkResponseCode.ERROR_NORMAL);
        }
        return response;
    }

    @PostMapping("/getMath")
    @ApiOperation(value = "随机获取", notes = "随机获取")
    public Response<RealHeart> getMath(){
        Response response = null;
        try {
            List<RealHeart> list = realHeartService.getMath();
            Random random = new Random();
            int i = random.nextInt(list.size());
            response = new Response(list.get(i));
        } catch (ParamException e) {
            log.error(e.getMessage(),e);
            response = new Response(e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            response = new Response(TkResponseCode.ERROR_NORMAL);
        }
        return response;
    }

}
