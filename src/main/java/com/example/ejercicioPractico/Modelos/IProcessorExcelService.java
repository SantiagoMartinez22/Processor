package com.example.ejercicioPractico.Modelos;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IProcessorExcelService {
  List<DataSafety> readExcelFile(String filePath) throws IOException, ParseException;
}
