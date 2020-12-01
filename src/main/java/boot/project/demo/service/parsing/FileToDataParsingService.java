package boot.project.demo.service.parsing;

import java.util.List;

public interface FileToDataParsingService<T> {
    List<T> parse(String filePath);
}
