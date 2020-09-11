package com.zmm.milletucapi.service;

import com.zmm.milletucapi.dao.HeardStormDao;
import com.zmm.milletucapi.entity.HeardStorm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
* @description HeardStorm业务层
* @author  bigdata
* @since  2020-05-21 14:54:26
*/
@Service
@Slf4j
public class HeardStormService extends BaseService<HeardStorm> {

    @Autowired
    private HeardStormDao heardStormDao;

    public List<HeardStorm> getMath(){
        Example example = new Example(HeardStorm.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isUsed",0);
        return heardStormDao.selectByExample(example);
    }

}
