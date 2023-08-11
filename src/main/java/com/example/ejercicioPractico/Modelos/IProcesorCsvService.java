package com.example.ejercicioPractico.Modelos;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IProcesorCsvService {
    public List<Persona> readCsvFile(String filePath)throws IOException , ParseException;

}
