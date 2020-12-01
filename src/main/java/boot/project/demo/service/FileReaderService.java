package boot.project.demo.service;

import java.util.List;

public interface FileReaderService {
    List<String[]> readFile(String filePath);
}
