package boot.project.demo.service.impl;

import boot.project.demo.service.FileReaderService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String[]> readFile(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (Reader reader = new FileReader(new File(filePath))) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                data.add(nextLine);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Can't read csv file " + filePath, e);
        }
        return data;
    }
}
