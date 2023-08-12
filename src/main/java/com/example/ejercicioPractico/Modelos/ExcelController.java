package com.example.ejercicioPractico.Modelos;
import com.example.ejercicioPractico.Modelos.ExcelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@RestController
    public class ExcelController {

        private final IProcessorExcelService iprocesorExcelService;

        @Autowired
        public ExcelController(IProcessorExcelService iprocesorExcelService) {
            this.iprocesorExcelService = iprocesorExcelService;
        }

        @PostMapping("/process-excel")
        public ResponseEntity<List<DataSafety>> processExcel(@RequestParam("filePath") String filePath) throws IOException {
            try {
                List<DataSafety> dataSafetyList = iprocesorExcelService.readExcelFile(filePath);
                return new ResponseEntity<>(dataSafetyList, HttpStatus.OK);
            } catch (IOException | ParseException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


