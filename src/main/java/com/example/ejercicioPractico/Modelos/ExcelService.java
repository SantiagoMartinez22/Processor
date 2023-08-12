package com.example.ejercicioPractico.Modelos;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService implements IProcessorExcelService {

    public List<DataSafety> readExcelFile(String filePath) throws IOException, ParseException {
        List<DataSafety> dataSafetyList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");

            for (Row row : sheet) {
                DataSafety dataSafety = new DataSafety();
                dataSafety.setDate(dateFormat.parse(row.getCell(0).getStringCellValue()));
                dataSafety.setInjuryLocation(row.getCell(1).getStringCellValue());
                dataSafety.setGender(row.getCell(2).getStringCellValue());
                dataSafety.setAgeGroup(row.getCell(3).getStringCellValue());
                dataSafety.setIncidentType(row.getCell(4).getStringCellValue());
                dataSafety.setDaysLost(row.getCell(5).getNumericCellValue());
                dataSafety.setPlant(row.getCell(6).getStringCellValue());
                dataSafety.setReportType(row.getCell(7).getStringCellValue());
                dataSafety.setShift(row.getCell(8).getStringCellValue());
                dataSafety.setDepartment(row.getCell(9).getStringCellValue());
                dataSafety.setIncidentCost(row.getCell(10).getNumericCellValue());
                dataSafetyList.add(dataSafety);
                System.out.println(dataSafety.getDepartment());
            }
        }

        return dataSafetyList;
    }
}



