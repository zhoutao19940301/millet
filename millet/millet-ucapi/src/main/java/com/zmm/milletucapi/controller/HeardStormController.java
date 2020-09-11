package com.zmm.milletucapi.controller;

import com.zmm.milletucapi.common.ParamException;
import com.zmm.milletucapi.common.Response;
import com.zmm.milletucapi.common.TkResponseCode;
import com.zmm.milletucapi.entity.HeardStorm;
import com.zmm.milletucapi.entity.RealHeart;
import com.zmm.milletucapi.service.HeardStormService;
import com.zmm.milletucapi.service.RealHeartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;

/**
* @Descriprion HeardStorm控制层
* @Author  bigdata
* @Date  2020-05-21 14:54:26
*/
@Api(tags = "HeardStorm管理")
@RestController
@RequestMapping("/heardStorm")
@Slf4j
@Validated
@CrossOrigin
public class HeardStormController {

    @Autowired
    private HeardStormService heardStormService;

    @Autowired
    private RealHeartService realHeartService;

    @PostMapping("/delete")
    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    public Response deleteHeardStorm(@NotNull(message = "id不能为空") @RequestParam Object id){
        Response response = null;
        try {
            heardStormService.deleteById(id);
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

    @PostMapping("/update")
    @ApiOperation(value = "更新", notes = "更新")
    public Response updateHeardStorm(@Valid @RequestBody HeardStorm req){
        Response response = null;
        try {
            heardStormService.updateById(req);
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
    public Response<HeardStorm> getMath(){
        Response response = null;
        try {
            List<HeardStorm> list = heardStormService.getMath();
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

    @PostMapping("/getRealHeart")
    @ApiOperation(value = "随机获取真心话", notes = "随机获取真心话")
    public Response<RealHeart> getRealHeart(){
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

    @PostMapping("/updateRealHeart")
    @ApiOperation(value = "更新真心话", notes = "更新真心话")
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

}
