package com.zmm.milletucapi.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * EasyExcelExportUtils
 *
 * @author lujian@talkweb.com.cn
 * @date 2022/6/24
 * @apiNote 导出
 */
@Slf4j
public final class EasyExcelExportUtils {

    private EasyExcelExportUtils() {}

    /**
     * 功能描述：
     * 〈导出excel到指定路径下〉
     * @author lujian@talkweb.com.cn
     * @date 2022/6/11
     * @param path 路径
     * @param excelName 文件名称
     * @param sheetName sheet名称
     * @param clazz 需要转换的类型
     * @param data 需要导出的数据
     */
    public static void export2File(String path, String excelName, String sheetName, Class<?> clazz, List<?> data) {
        String fileName = path.concat(excelName).concat(ExcelTypeEnum.XLSX.getValue());
        EasyExcelFactory.write(fileName, clazz).sheet(sheetName).doWrite(data);
    }



    /**
     * 功能描述：
     * 〈导出Excel到web〉
     * @author lujian@talkweb.com.cn
     * @date 2022/6/11
     * @param response response相应
     * @param excelName 文件名称
     * @param sheetName sheet名称
     * @param clazz 需要转换的类型
     * @param data 需要导出的数据
     * @throws IOException  异常
     */

    public static void export2Web(HttpServletResponse response, String excelName, String sheetName, Class<?> clazz,List<List<String>> head, List<?> data) throws IOException {
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        excelName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+excelName+ ExcelTypeEnum.XLSX.getValue());
        EasyExcelFactory.write(response.getOutputStream(), clazz).sheet(sheetName).head(head).doWrite(data);
    }

    public static void export2WebYeah(HttpServletResponse response, String excelName, String sheetName, Class<?> clazz, List<?> data) throws IOException {
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        excelName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+excelName+ ExcelTypeEnum.XLSX.getValue());
        EasyExcelFactory.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(data);
    }

    /**
     * 功能描述：
     * 〈将指定位置指定名称的Excel导出到web〉
     * @author lujian@talkweb.com.cn
     * @date 2022/6/11
     * @param response  响应
     * @param path      文件路径
     * @param excelName 文件名称
     * @throws  UnsupportedEncodingException 异常
     * @return String 返回值
     */
    public static String export2Web4File(HttpServletResponse response, String path, String excelName) throws UnsupportedEncodingException {
        File file = new File(path.concat(excelName).concat(ExcelTypeEnum.XLSX.getValue()));
        if (!file.exists()) {
            return "文件不存在！";
        }

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        excelName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + excelName + ExcelTypeEnum.XLSX.getValue());

        try (
                FileInputStream in = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream()
        ) {
            IOUtils.copy(in, out);
            return "导出成功！";
        } catch (Exception e) {
            log.error("导出文件异常：", e);
        }

        return "导出失败！";
    }

}
