package com.youguu.intelligent.second.excel;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2019/3/7.
 * 0 序号
 * 1 题目类型
 * 2 问题
 * 3,4,5,6,7,8 答案
 * 9 解析
 * 10 答案
 * 11 分值
 * 12 考试类别
 * 13 科目名称
 * 14 章
 * 15 节
 * 16 难度系数
 * 17,18,19,20 知识点
 * 21
 * 22 年份
 */
@Service("excel")
public class ExcelImpl {


    /**
     * 抽取表格的题目
     * @return
     * @throws IOException
     */
    public List<Market> transToList(String path){

        List<Market> list = new ArrayList<>();
        //String pname = path.getName().toLowerCase();
        String pname = path.substring(path.lastIndexOf("/")+1);
        if(!pname.startsWith("~$") && pname.endsWith("xlsx")){
            list = transXss(path);
        }
        return list;
    }


    public List<Market> transXss(String path){

        List<Market> list = new ArrayList<>();
        XSSFWorkbook xssfWorkbook = null;
        InputStream ism = null;
        try {

            ism = new FileInputStream(path);
            //InputStream is=this.getClass().getResourceAsStream(path);

            xssfWorkbook = new XSSFWorkbook(ism);

            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

            for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {

                XSSFRow xssfRow = xssfSheet.getRow(i);

                String title = getValue(xssfRow.getCell(0)).trim();

                title = title.split("\\s")[0];

                if(title.indexOf("(")>0){
                    title = title.split("\\(")[0];
                }

                String first = getValue(xssfRow.getCell(1)).trim();

                String secondTitle = getValue(xssfRow.getCell(2)).trim();

                String stockCode = getValue(xssfRow.getCell(3));

                stockCode.split(",");

                String[] str = stockCode.split(",");

                if(str.length>1){
                    stockCode = str[0]+""+str[1];
                }


                int length = stockCode.length();
                if(length!=6){
                    int cha = 6 - length;
                    for (int j = 0; j < cha; j++) {
                        stockCode = "0"+ stockCode;
                    }
                }
                String stockName = getValue(xssfRow.getCell(4));

                Market market = new Market(title, secondTitle, stockCode, stockName);

                list.add(market);

                System.out.println(title+":"+secondTitle+":"+stockCode+":"+stockName);

                System.out.println("i:"+i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ism != null){
                try {
                    ism.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    private static String getValue(XSSFCell xssfRow) {
        if (xssfRow != null) {

            if (xssfRow.getCellType() == CellType.BOOLEAN) {
                return String.valueOf(xssfRow.getBooleanCellValue());
            } else if (xssfRow.getCellType() == CellType.NUMERIC) {
                String result = "";
                if (xssfRow.getCellStyle().getDataFormat() == 22) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    double value = xssfRow.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                    result = sdf.format(date);
                } else {

                    double value = xssfRow.getNumericCellValue();
                    CellStyle style = xssfRow.getCellStyle();
                    DecimalFormat format = new DecimalFormat();
                    String temp = style.getDataFormatString();
                    // 单元格设置成常规
                    if (temp.equals("General")) {
                        format.applyPattern("#");
                    }
                    result = format.format(value);
                }
                return result;
            } else {
                return xssfRow.getStringCellValue()+"";
            }
        } else
            return "0";
    }



    public static void main(String[] args) {

        ExcelImpl excel = new ExcelImpl();

        excel.transXss("E:/data/writeStock/market2019.xlsx");

    }

}


