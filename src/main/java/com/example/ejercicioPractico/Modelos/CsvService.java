package com.example.ejercicioPractico.Modelos;
import org.springframework.stereotype.Service;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CsvService implements IProcesorCsvService {

    public List<Persona> readCsvFile(String filePath) throws IOException, ParseException {
        List<Persona> personas = new ArrayList<>();

        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (CSVRecord csvRecord : csvParser) {
                Persona persona = new Persona();
                persona.setIndex(Integer.parseInt(csvRecord.get("Index")));
                persona.setUserId(csvRecord.get("User Id"));
                persona.setFirstName(csvRecord.get("First Name"));
                persona.setLastName(csvRecord.get("Last Name"));
                persona.setSex(csvRecord.get("Sex"));
                persona.setEmail(csvRecord.get("Email"));
                persona.setPhone(csvRecord.get("Phone"));
                persona.setDateOfBirth(dateFormat.parse(csvRecord.get("Date of birth")));
                persona.setJobTitle(csvRecord.get("Job Title"));
                personas.add(persona);
                System.out.println(persona.getUserId());
            }

        }

        return personas;
    }
}



