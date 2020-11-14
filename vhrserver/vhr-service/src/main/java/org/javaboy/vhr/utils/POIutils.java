package org.javaboy.vhr.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.javaboy.vhr.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RJY
 * @version 1.0
 * @date 2020/9/21 12:04
 * @CreateTime: 2020-09-21 12:04
 */
public class POIutils {

    public static ResponseEntity<byte[]> export2ex(List<Employee> list) {

        //创作工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //获取文档摘要
        workbook.createInformationProperties();
        //获取文档配置
        DocumentSummaryInformation documentSummaryInformation = workbook.getDocumentSummaryInformation();
        //文档类别
        documentSummaryInformation.setCategory("员工信息");
        //设置文档管理员
        documentSummaryInformation.setManager("码金豆");
        //设置文档公司
        documentSummaryInformation.setCompany("github项目开源集合地");

        //获取文档摘要信息
        SummaryInformation information = workbook.getSummaryInformation();

        //设置标题
        information.setTitle("员工信息表");
        //设置作者
        information.setAuthor("code金豆");
        //设置文档备注
        information.setComments("本文档有code金豆提供");

        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle datacellStyle = workbook.createCellStyle();
        datacellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        //创建工作表
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        //设置表列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 20 * 256);
        sheet.setColumnWidth(5, 12 * 256);
        sheet.setColumnWidth(6, 20 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 10 * 256);
        sheet.setColumnWidth(9, 16 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 15 * 256);
        sheet.setColumnWidth(13, 12 * 256);
        sheet.setColumnWidth(14, 12 * 256);
        sheet.setColumnWidth(15, 14 * 256);
        sheet.setColumnWidth(16, 13 * 256);
        sheet.setColumnWidth(17, 16 * 256);
        sheet.setColumnWidth(18, 16 * 256);
        sheet.setColumnWidth(19, 16 * 256);
        sheet.setColumnWidth(20, 16 * 256);
        sheet.setColumnWidth(21, 15 * 256);
        sheet.setColumnWidth(22, 10 * 256);
        sheet.setColumnWidth(23, 7 * 256);
        sheet.setColumnWidth(24, 7 * 256);

        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);

        c0.setCellStyle(headerStyle);
        c0.setCellValue("编号");
        HSSFCell c1 = r0.createCell(1);

        c1.setCellValue("姓名");
        c1.setCellStyle(headerStyle);
        HSSFCell c2 = r0.createCell(2);

        c2.setCellValue("工号");
        c2.setCellStyle(headerStyle);
        HSSFCell c3 = r0.createCell(3);

        c3.setCellValue("性别");
        c3.setCellStyle(headerStyle);
        HSSFCell c4 = r0.createCell(4);

        c4.setCellValue("出生日期");
        c4.setCellStyle(headerStyle);
        HSSFCell c5 = r0.createCell(5);

        c5.setCellValue("身份证号码");
        c5.setCellStyle(headerStyle);
        HSSFCell c6 = r0.createCell(6);

        c6.setCellValue("婚姻状况");
        c6.setCellStyle(headerStyle);
        HSSFCell c7 = r0.createCell(7);
        c7.setCellValue("民族");
        c7.setCellStyle(headerStyle);
        HSSFCell c8 = r0.createCell(8);
        c8.setCellValue("籍贯");
        c8.setCellStyle(headerStyle);
        HSSFCell c9 = r0.createCell(9);
        c9.setCellValue("政治面貌");
        c9.setCellStyle(headerStyle);
        HSSFCell c10 = r0.createCell(10);
        c10.setCellValue("电子邮件");
        c10.setCellStyle(headerStyle);
        HSSFCell c11 = r0.createCell(11);
        c11.setCellValue("电话号码");
        c11.setCellStyle(headerStyle);
        HSSFCell c12 = r0.createCell(12);
        c12.setCellValue("联系地址");
        c12.setCellStyle(headerStyle);
        HSSFCell c13 = r0.createCell(13);
        c13.setCellValue("所属部门");
        c13.setCellStyle(headerStyle);
        HSSFCell c14 = r0.createCell(14);
        c14.setCellValue("职位");
        c14.setCellStyle(headerStyle);
        HSSFCell c15 = r0.createCell(15);
        c15.setCellValue("职称");
        c15.setCellStyle(headerStyle);
        HSSFCell c16 = r0.createCell(16);
        c16.setCellValue("聘用形式");
        c16.setCellStyle(headerStyle);
        HSSFCell c17 = r0.createCell(17);
        c17.setCellValue("入职日期");
        c17.setCellStyle(headerStyle);
        HSSFCell c18 = r0.createCell(18);
        c18.setCellValue("转正日期");
        c18.setCellStyle(headerStyle);
        HSSFCell c19 = r0.createCell(19);
        c19.setCellValue("合同起始日期");
        c19.setCellStyle(headerStyle);
        HSSFCell c20 = r0.createCell(20);
        c20.setCellValue("合同截止日期");
        c20.setCellStyle(headerStyle);
        HSSFCell c21 = r0.createCell(21);
        c21.setCellValue("合同期限(年)");
        c21.setCellStyle(headerStyle);
        HSSFCell c22 = r0.createCell(22);
        c22.setCellValue("毕业院校");
        c22.setCellStyle(headerStyle);
        HSSFCell c23 = r0.createCell(23);
        c23.setCellValue("专业");
        c23.setCellStyle(headerStyle);
        HSSFCell c24 = r0.createCell(24);
        c24.setCellValue("最高学历");
        c24.setCellStyle(headerStyle);

        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkID());
            row.createCell(3).setCellValue(emp.getGender());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(datacellStyle);
            cell4.setCellValue(emp.getBirthday());
            row.createCell(5).setCellValue(emp.getIdCard());
            row.createCell(6).setCellValue(emp.getWedlock());
            row.createCell(7).setCellValue(emp.getNation().getName());
            row.createCell(8).setCellValue(emp.getNativePlace());
            row.createCell(9).setCellValue(emp.getPoliticsstatus().getName());
            row.createCell(10).setCellValue(emp.getEmail());
            row.createCell(11).setCellValue(emp.getPhone());
            row.createCell(12).setCellValue(emp.getAddress());
            row.createCell(13).setCellValue(emp.getDepartment().getName());
            row.createCell(14).setCellValue(emp.getPosition().getName());
            row.createCell(15).setCellValue(emp.getJobLevel().getName());
            row.createCell(16).setCellValue(emp.getEngageForm());
            HSSFCell cell17 = row.createCell(17);
            cell17.setCellStyle(datacellStyle);
            cell17.setCellValue(emp.getBeginDate());
            HSSFCell cell18 = row.createCell(18);
            cell18.setCellStyle(datacellStyle);
            cell18.setCellValue(emp.getConversionTime());
            HSSFCell cell19 = row.createCell(19);
            cell19.setCellStyle(datacellStyle);
            cell19.setCellValue(emp.getBeginContract());
            HSSFCell cell20 = row.createCell(20);
            cell20.setCellStyle(datacellStyle);
            cell20.setCellValue(emp.getEndContract());
            row.createCell(21).setCellValue(emp.getContractTerm());
            row.createCell(22).setCellValue(emp.getSchool());
            row.createCell(23).setCellValue(emp.getSpecialty());
            row.createCell(24).setCellValue(emp.getTiptopDegree());

        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            workbook.write(baos);
            headers.setContentDispositionFormData("attachment", new String("员工信息表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }


    /**
     * 解析成  员工数据集合
     *
     * @param file
     * @param allNation
     * @param allPosta
     * @param deparmentAll
     * @param allPosition
     * @param jobLevelsAll
     * @return
     */
    public static List<Employee> excel2Employee(MultipartFile file, List<Nation> allNation, List<Politicsstatus> allPosta,
                                                List<Department> deparmentAll, List<Position> allPosition, List<JobLevel> jobLevelsAll) {

        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(file.getInputStream());
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int rows = sheet.getPhysicalNumberOfRows();

                for (int j = 0; j < rows; j++) {
                    //跳过标题行
                    if (j == 0) {
                        continue;
                    }
                    //获取行
                    HSSFRow row = sheet.getRow(j);
                    //防止表单有空行
                    if (row == null) {
                        continue;
                    }
                    //获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        employee.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        employee.setGender(cellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        int nationIndex = allNation.indexOf(new Nation(cellValue));
                                        employee.setNationId(allNation.get(nationIndex).getId());
                                        break;
                                    case 8:
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        int of = allPosta.indexOf(new Politicsstatus(cellValue));
                                        employee.setPoliticId(allPosta.get(of).getId());
                                        break;
                                    case 10:
                                        employee.setEmail(cellValue);
                                        break;
                                    case 11:
                                        employee.setPhone(cellValue);
                                        break;
                                    case 12:
                                        employee.setAddress(cellValue);
                                        break;
                                    case 13:
                                        int indexOf = deparmentAll.indexOf(new Department(cellValue));
                                        employee.setDepartmentId(deparmentAll.get(indexOf).getId());
                                        break;
                                    case 14:
                                        int index1 = allPosition.indexOf(new Position(cellValue));
                                        employee.setPosId(allPosition.get(index1).getId());
                                        break;
                                    case 15:
                                        int index2 = jobLevelsAll.indexOf(new JobLevel(cellValue));
                                        employee.setJobLevelId(jobLevelsAll.get(index2).getId());
                                        break;
                                    case 16:
                                        employee.setEngageForm(cellValue);
                                        break;
                                    case 22:
                                        employee.setSchool(cellValue);
                                        break;
                                    case 23:
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 24:
                                        employee.setSchool(cellValue);
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 17:
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 18:
                                        employee.setConversionTime(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 20:
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 21:
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    list.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取表单的数量

        return list;
    }
}

 
