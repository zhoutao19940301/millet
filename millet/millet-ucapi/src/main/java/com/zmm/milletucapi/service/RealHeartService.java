package com.zmm.milletucapi.service;

import com.zmm.milletucapi.dao.RealHeartDao;
import com.zmm.milletucapi.entity.RealHeart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* @description RealHeart业务层
* @author  bigdata
* @since  2020-05-22 16:32:36
*/
@Service
@Slf4j
public class RealHeartService extends BaseService<RealHeart> {

    @Resource
    private RealHeartDao realHeartDao;

    public List<RealHeart> getMath(){
        Example example = new Example(RealHeart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isUsed",0);
        return realHeartDao.selectByExample(example);
    }

}
