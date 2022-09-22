package com.zmm.milletucapi.service;

import com.zmm.milletucapi.dao.GoodsTypeMapper;
import com.zmm.milletucapi.entity.GoodsType;
import com.zmm.milletucapi.entity.dto.ClassifyMoneyDto;
import com.zmm.milletucapi.entity.dto.ExpendMoneyDto;
import com.zmm.milletucapi.entity.vo.QueryScopeVo;
import com.zmm.milletucapi.utils.EasyExcelExportUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GoodsTypeService {

    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Resource
    private RedisTemplate redisTemplate;

    public List<GoodsType> findAll(){
        List<GoodsType> list = goodsTypeMapper.findAllGoods();
        return list;
    }

    public void getContractMoneyByClassify(HttpServletResponse response, QueryScopeVo queryScopeVo){
        List<ClassifyMoneyDto> list = goodsTypeMapper.getContractMoneyByClassify(queryScopeVo);
        /** 今天是哪个月 */
        int todayMonth = LocalDateTime.now().getMonthValue();
        /** 组装数据 */
        /** 表头 */
        List<List<String>> head = new ArrayList<>();
        /** 表数据 */
        List<List<String>> data = new ArrayList<>();
        List<String> headFirst = new ArrayList<>();
        headFirst.add("月份");
        head.add(headFirst);
        List<String> dataIncome = new ArrayList<>();
        Double totalIncome = 0d;
        dataIncome.add("收入类");
        List<String> dataExpend = new ArrayList<>(todayMonth);
        Double totalExpend = 0d;
        dataExpend.add("支出类");
        for(int i = 1; i<= todayMonth ; i++){
            List<String> tableHead = new ArrayList<>();
            tableHead.add(i+"月");
            head.add(tableHead);
            this.deal(list,1,totalIncome,dataIncome,String.valueOf(i));
            this.deal(list,2,totalExpend,dataExpend,String.valueOf(i));
        }
        List<String> headLast = new ArrayList<>();
        headLast.add("当年累计");
        head.add(headLast);
        dataIncome.add(String.valueOf(totalIncome));
        data.add(dataIncome);
        dataExpend.add(String.valueOf(totalExpend));
        data.add(dataExpend);

        try {
            EasyExcelExportUtils.export2Web(response, "测试", "测试列表", GoodsType.class,head, data);
        } catch (IOException e) {
            log.error("合同总览导出错误信息： ", e);
        }
    }

    /**
     * 业务名称
     * @author zhoutao21342@talkweb.com.cn
     * @apiNote 逻辑描述
     * @date 2022/8/25
     * @param: list 查询出的实体
     * @param: total 收入或支出类的当年累计
     * @param: tableData
     * @return
     **/
    private void deal(List<ClassifyMoneyDto> list,int classifyType,Double total,List<String> rowData,String compareMonth){
        String money = "0";
        for(ClassifyMoneyDto dto : list){
            int type = dto.getType();
            String month = dto.getMonth();
            if(type == classifyType && month.equals(compareMonth)){
                Double dtoMoney = dto.getMoney();
                total += dtoMoney;
                money = String.valueOf(dtoMoney);
            }
        }
        rowData.add(money);
    }

    public void exportByExpend(HttpServletResponse response, QueryScopeVo queryScopeVo){
        List<ExpendMoneyDto> list = goodsTypeMapper.getContractMoneyByExpend(queryScopeVo);
        /** 组装数据 */
        /** 表头 */
        List<List<String>> head = new ArrayList<>();
        /** 表数据 */
        List<List<String>> data = new ArrayList<>();
        List<String> headFirst = new ArrayList<>();
        headFirst.add("支出类型");
        head.add(headFirst);
        List<String> dataExpend = new ArrayList<>();
        Double totalExpend = 0d;
        dataExpend.add("支出金额(百万)");
        for(ExpendMoneyDto dto : list){
            String typeName = dto.getTypeName();
            Double typeMoney = dto.getMoney();
            List<String> tableHead = new ArrayList<>();
            tableHead.add(typeName);
            head.add(tableHead);
            dataExpend.add(String.valueOf(typeMoney));
            totalExpend += typeMoney;
        }
        List<String> headLast = new ArrayList<>();
        headLast.add("合计");
        head.add(headLast);
        dataExpend.add(String.valueOf(totalExpend));
        data.add(dataExpend);
//        try {
//            EasyExcelExportUtils.export2Web(response, "测试", "测试列表", GoodsType.class,head, data);
//        } catch (IOException e) {
//            log.error("合同总览导出错误信息： ", e);
//        }
    }

    public void exportExpendMonitor(HttpServletResponse response, QueryScopeVo queryScopeVo) throws IOException {
        /** 表头 */
        List<List<String>> tableHead = new ArrayList<>();
        String[] headArray = {"合同编号","合同名称","订单","订单接收","付款","办结","非正常履行事项","承办部门","承办人","对方全称","合同类型","含增值税合同金额","累计订单金额","累计接收金额","累计付款金额"};
        for(String headString : headArray){
            List<String> head = new ArrayList<>();
            head.add(headString);
            tableHead.add(head);
        }
        List<List<String>> tableData = new ArrayList<>();
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        data.add("1");
        tableData.add(data);
        EasyExcelExportUtils.export2Web(response, "支出类", "sheet1", GoodsType.class, tableHead,tableData);
    }

    public static void main(String[] args) {
        String month = "1000";
        int monthInt = 1000;
        Integer type =  2;
        System.out.println(type == 2);
    }

    @Scheduled
    public void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        ListOperations listOperations = redisTemplate.opsForList();
        HashOperations hashOperations = redisTemplate.opsForHash();
        SetOperations setOperations = redisTemplate.opsForSet();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
    }

}
