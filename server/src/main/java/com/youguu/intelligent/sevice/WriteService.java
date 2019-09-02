package com.youguu.intelligent.sevice;

import com.youguu.intelligent.pojo.TotalField;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WriteService {

    private String dir;

    public WriteService(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public static void main(String[] args) {

        WriteService writeService = new WriteService("");

        String path = "E:/gen/a.xls";
        try {
            writeService.gen(path, new HashMap<>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gen(String dir, Map<Long, TotalField> map) throws IOException {

        File file = new File(dir);

        if(file.exists()){
            file.delete();
        }

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }

        writeExcel(dir, map);
    }

    public void writeExcel(String file, Map<Long, TotalField> map) throws IOException {

        HSSFWorkbook excel = new HSSFWorkbook();

        HSSFSheet sheet = excel.createSheet();

        HSSFCellStyle cellStyle=excel.createCellStyle();

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        int rowNum = 0;
        String[] headers =
                {"股票代码","股票名称","公司编码","净利润","经营性现金流净额", "总资产收益率", "净资产收益率","总股本", "资产负债率",
                        "资产总计", "负债合计", "非流动负债合计","流动比率", "毛利率", "总资产周转率", "营业收入", "股东总户数","截止日期"};
        HSSFRow row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);
        row.setHeightInPoints(20);
        // 将标题放入进去
        for (int i = 0; i < headers.length; i++) {
            // 创建一个单元格
            HSSFCell cell = row.createCell(i);
            // 将数据转换为字符串
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            // 将数据放入进去
            cell.setCellValue(text);

            cell.setCellStyle(cellStyle);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

        for (TotalField totalField : map.values()) {

            if(totalField !=null){
                ++rowNum;
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(totalField.getStockCode());
                row1.createCell(1).setCellValue(totalField.getStockName());
                row1.createCell(2).setCellValue(totalField.getComcode());
                row1.createCell(3).setCellValue(totalField.getNetprofit());//净利润
                row1.createCell(4).setCellValue(totalField.getNetcashflowoper());//经营性现金流净额
                row1.createCell(5).setCellValue(totalField.getRoa());//总资产收益率
                row1.createCell(6).setCellValue(totalField.getRoe());//净资产收益率
                row1.createCell(7).setCellValue(totalField.getTotalshare());//总股本
                row1.createCell(8).setCellValue(totalField.getTltota());//资产负债率
                row1.createCell(9).setCellValue(totalField.getTotalasset());//资产总计
                row1.createCell(10).setCellValue(totalField.getTotalliab());//负债合计
                row1.createCell(11).setCellValue(totalField.getTotalnoncurliab());//非流动负债合计
                row1.createCell(12).setCellValue(totalField.getCurrentratio());//流动比率
                row1.createCell(13).setCellValue(totalField.getGrossprofitmargin());//毛利率
                row1.createCell(14).setCellValue(totalField.getTotalassetturnover());//总资产周转率
                row1.createCell(15).setCellValue(totalField.getOperrevenue());//营业收入
                row1.createCell(16).setCellValue(totalField.getTotalSh());//股东总户数

                Date date = totalField.getEnddate();

                row1.createCell(17).setCellValue(date==null?"":sdf.format(date));//截止日期

                row1.setRowStyle(cellStyle);

                sheet.setDefaultRowHeightInPoints(10);//设置缺省列高
                sheet.setDefaultColumnWidth(15);//设置缺省列宽
            }
        }

        excel.write(new File(file));

    }
}
