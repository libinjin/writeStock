package com.youguu.intelligent.sevice;

import com.youguu.intelligent.pojo.TotalField;
import com.youguu.intelligent.second.BOLLPoint;
import com.youguu.intelligent.second.ChangePer;
import com.youguu.intelligent.second.MarkertPer;
import com.youguu.intelligent.second.TotalMap;
import com.youguu.intelligent.second.VolumnPer;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
                {"股票代码","股票名称","公司编码","净利润\nNetProfit","经营性现金流净额\nNetCashFlowOper", "总资产收益率\nROA",
                        "净资产收益率\nROE","总股本\nTotalShare", "资产负债率\nTLToTA",
                        "资产总计\nTotalAsset", "负债合计\nTotalLiab", "非流动负债合计\nTotalNonCurLiab",
                        "流动比率\nCurrentRatio", "毛利率\nGrossProfitMargin", "总资产周转率\nTotalAssetTurnover",
                        "营业收入\nOperRevenue", "股东总户数","截止日期"};
        HSSFRow row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);
        row.setHeightInPoints(30);
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

    public void genSeond(String dir, TotalMap totalMap) throws IOException {

        File file = new File(dir);

        if(file.exists()){
            file.delete();
        }

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }

        writeSecondExcel(dir, totalMap);
    }

    private void writeSecondExcel(String dir, TotalMap totalMap) {

        switch (dir){
            case "E:/gen/changPercnet.xls":
                writeChangePerExecl(dir, totalMap.getChangePercentMap());
                break;
            case "E:/gen/volumn.xls":
                writeVolumExecl(dir, totalMap.getVolumeMap());
                break;
            case "E:/gen/Boll.xls":
                writeBollExecl(dir, totalMap.getBollPointMap());
                break;
            case "E:/gen/marketRank.xls":
                writeMarketExecl(dir, totalMap.getMarketMap());
                break;
        }
    }

    public void writeChangePerExecl(String dir, Map<String , List<ChangePer>> changePercentMap){

        HSSFWorkbook excel = new HSSFWorkbook();

        HSSFSheet sheet = excel.createSheet();

        HSSFCellStyle cellStyle=excel.createCellStyle();

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        int rowNum = 0;
        //String[] headers = {"股票代码","涨跌幅","日期"};

        List<String> headers = new ArrayList<>();
        headers.add("股票代码");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Iterator<List<ChangePer>> it =  changePercentMap.values().iterator();
        List<ChangePer> changePerList =  it.next();

        for (int i = 0; i < changePerList.size(); i++) {

            ChangePer changePer = changePerList.get(i);

            String date = changePer.getDate()+"";

            headers.add(date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6));
        }

        HSSFRow row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);
        row.setHeightInPoints(20);
        // 将标题放入进去

        for (int i = 0; i < headers.size(); i++) {
            // 创建一个单元格
            HSSFCell cell = row.createCell(i);
            // 将数据转换为字符串
            HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
            // 将数据放入进去
            cell.setCellValue(text);

            cell.setCellStyle(cellStyle);
        }


        for (Map.Entry<String , List<ChangePer>> entry : changePercentMap.entrySet()) {

            String stockCode = entry.getKey();

            List<ChangePer> valList = entry.getValue();

            ++rowNum;
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(stockCode);

            for (int i = 0; i < valList.size(); i++) {

                ChangePer changePer = valList.get(i);
                row1.createCell(i+1).setCellValue(changePer.getChangePercent());

            }

            row1.setRowStyle(cellStyle);

            sheet.setDefaultRowHeightInPoints(10);//设置缺省列高
            sheet.setDefaultColumnWidth(15);//设置缺省列宽
        }
        try {
            excel.write(new File(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeVolumExecl(String dir, Map<String, List<VolumnPer>> volumMap) {
        HSSFWorkbook excel = new HSSFWorkbook();

        HSSFSheet sheet = excel.createSheet();

        HSSFCellStyle cellStyle=excel.createCellStyle();

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        int rowNum = 0;
        //String[] headers = {"股票代码","涨跌幅","日期"};

        List<String> headers = new ArrayList<>();
        headers.add("股票代码");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Iterator<List<VolumnPer>> it =  volumMap.values().iterator();
        List<VolumnPer> volumnPerList =  it.next();

        for (int i = 0; i < volumnPerList.size(); i++) {

            VolumnPer volumnPer = volumnPerList.get(i);

            String date = volumnPer.getDate()+"";

            headers.add(date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6));
        }

        HSSFRow row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);
        row.setHeightInPoints(20);
        // 将标题放入进去

        for (int i = 0; i < headers.size(); i++) {
            // 创建一个单元格
            HSSFCell cell = row.createCell(i);
            // 将数据转换为字符串
            HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
            // 将数据放入进去
            cell.setCellValue(text);

            cell.setCellStyle(cellStyle);
        }


        for (Map.Entry<String , List<VolumnPer>> entry : volumMap.entrySet()) {

            String stockCode = entry.getKey();

            List<VolumnPer> valList = entry.getValue();

            ++rowNum;
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(stockCode);

            for (int i = 0; i < valList.size(); i++) {

                VolumnPer volumnPer = valList.get(i);
                row1.createCell(i+1).setCellValue(volumnPer.getVolume());

            }

            row1.setRowStyle(cellStyle);

            sheet.setDefaultRowHeightInPoints(10);//设置缺省列高
            sheet.setDefaultColumnWidth(15);//设置缺省列宽
        }
        try {
            excel.write(new File(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //type 1 布林线的下轨 支撑位  2 布林线的上轨 阻力位
    private void writeBollExecl(String dir, Map<String, BOLLPoint> bollPointMap) {

        HSSFWorkbook excel = new HSSFWorkbook();

        HSSFSheet sheet = excel.createSheet();

        HSSFCellStyle cellStyle=excel.createCellStyle();

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        int rowNum = 0;
        //String[] headers = {"股票代码","涨跌幅","日期"};

        List<String> headers = new ArrayList<>();
        headers.add("股票代码");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Iterator<BOLLPoint> it =  bollPointMap.values().iterator();
        BOLLPoint bollPoint =  it.next();

        headers.add("支撑位");
        headers.add("阻力位");

        HSSFRow row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);
        row.setHeightInPoints(20);
        // 将标题放入进去

        for (int i = 0; i < headers.size(); i++) {
            // 创建一个单元格
            HSSFCell cell = row.createCell(i);
            // 将数据转换为字符串
            HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
            // 将数据放入进去
            cell.setCellValue(text);

            cell.setCellStyle(cellStyle);
        }


        for (Map.Entry<String , BOLLPoint> entry : bollPointMap.entrySet()) {

            String stockCode = entry.getKey();

            BOLLPoint bollPoint1 = entry.getValue();

            ++rowNum;
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(stockCode);

            row1.createCell(1).setCellValue(bollPoint1.getLower());

            row1.createCell(2).setCellValue(bollPoint1.getUpper());

            row1.setRowStyle(cellStyle);

            sheet.setDefaultRowHeightInPoints(10);//设置缺省列高
            sheet.setDefaultColumnWidth(15);//设置缺省列宽
        }
        try {
            excel.write(new File(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeMarketExecl(String dir, Map<String, MarkertPer> marketMap) {

        HSSFWorkbook excel = new HSSFWorkbook();

        HSSFSheet sheet = excel.createSheet();

        HSSFCellStyle cellStyle=excel.createCellStyle();

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        int rowNum = 0;
        List<String> headers = new ArrayList<>();

        headers.add("股票代码");

        headers.add("排名");

        headers.add("行业");

        headers.add("涨跌幅");

        HSSFRow row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);
        row.setHeightInPoints(20);
        // 将标题放入进去

        for (int i = 0; i < headers.size(); i++) {
            // 创建一个单元格
            HSSFCell cell = row.createCell(i);
            // 将数据转换为字符串
            HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
            // 将数据放入进去
            cell.setCellValue(text);

            cell.setCellStyle(cellStyle);
        }


        for (Map.Entry<String , MarkertPer> entry : marketMap.entrySet()) {

            String stockCode = entry.getKey();

            MarkertPer markertPer = entry.getValue();

            ++rowNum;
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(stockCode);

            row1.createCell(1).setCellValue(markertPer.getRank());

            row1.createCell(2).setCellValue(markertPer.getMarket());

            row1.createCell(3).setCellValue(markertPer.getChangePercent());

            row1.setRowStyle(cellStyle);

            sheet.setDefaultRowHeightInPoints(10);//设置缺省列高
            sheet.setDefaultColumnWidth(15);//设置缺省列宽
        }
        try {
            excel.write(new File(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
