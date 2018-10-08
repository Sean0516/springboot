package com.sean.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.sean.config.model.Bo;
import com.sean.config.model.Ext;
import com.sean.config.model.ExtBo;
import com.sean.config.model.ExtParam;
import com.sean.serivce.EasyPoiTest;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * Created by Sean on 2018/9/28
 *
 * @author Sean
 */
@RestController
public class EasyPoiController {
    @Autowired
   private  EasyPoiTest easyPoiTest;
    @RequestMapping("exportExt")
    public ResponseEntity export(HttpServletResponse httpServletResponse){
        List<ExtBo> extBoList=new ArrayList<>();
        ExtBo extBo=new ExtBo();
        extBo.setName("test");
        extBo.setStaff("sean");
        extBo.setDes("test is test ");
        Ext ext=new Ext();
        ext.setName("test");
        ext.setStaff("sean");
        ext.setDes("this is a test");
        ExtParam extParam=new ExtParam();
        extParam.setIp("1");
        extParam.setMac("233");
        extParam.setCoustom("hahaha");
        extBo.setExtParam(extParam);
        extBoList.add(extBo);
        ExtBo extBo2=new ExtBo();
        extBo2.setName("123");
        extBo2.setDes("123124");
        extBoList.add(extBo2);
        Bo bo=new Bo();
        bo.setHelp("this is help 1" +System.lineSeparator() +"this is help 2 "+System.lineSeparator());
        bo.setExtBoList(extBoList);
        List<Bo> boList=new ArrayList<>(1);
        boList.add(bo);
        Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams("test", null, "Sheet1"), Bo.class, boList);
        easyPoiTest.exportExcel(sheets,httpServletResponse,"testFile");
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping("export")
    public ResponseEntity export1(HttpServletResponse httpServletResponse){
        Ext ext=new Ext();
        ext.setName("test");
        ext.setStaff("sean");
        ext.setDes("this is a test");
        List<Ext> extList=new ArrayList<>();
        extList.add(ext);

        Map<String,Object> map1=new HashMap<>(3);
        map1.put("title",new ExportParams("Sheet1", null, "Sheet1"));
        map1.put("entity",Ext.class);
        map1.put("data",extList);

        ExtParam extParam=new ExtParam();
        extParam.setIp("1234");
        extParam.setMac("233");
        extParam.setCoustom("hahaha");
        List<ExtParam> extParamList=new ArrayList<>();
        extParamList.add(extParam);
        Map<String,Object> map2=new HashMap<>(3);
        map2.put("title",new ExportParams("Sheet2", null, "Sheet2"));
        map2.put("entity",ExtParam.class);
        map2.put("data",extParamList);

        List<Map<String,Object>> mapList=new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        Workbook sheets = ExcelExportUtil.exportExcel(mapList, ExcelType.HSSF);
        easyPoiTest.exportExcel(sheets,httpServletResponse,"testFile");
        return new ResponseEntity(HttpStatus.OK);
    }

    public static void main(String[] args) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<ExtBo> extBoList = ExcelImportUtil.importExcel(new File("D:\\testFile.xls"), ExtBo.class, params);
        for (ExtBo extBo : extBoList) {
            System.out.println(extBo.getExt().toString());
            System.out.println(extBo.getExtParam().toString());

        }
//        params.setStartSheetIndex(1);
//        List<ExtParam> extParamList = ExcelImportUtil.importExcel(new File("D:\\testFile1.xls"), ExtParam.class, params);
//        System.out.println(extParamList);
    }
}
