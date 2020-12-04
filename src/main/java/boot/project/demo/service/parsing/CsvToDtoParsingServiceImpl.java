package boot.project.demo.service.parsing;

import boot.project.demo.dto.ReviewRequestDto;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToDtoParsingServiceImpl implements FileToDataParsingService<ReviewRequestDto> {
    @Override
    public List<ReviewRequestDto> parse(String filePath) {
        try (FileReader fileReader = new FileReader(new File(filePath))) {
            return new CsvToBeanBuilder<ReviewRequestDto>(fileReader)
                    .withType(ReviewRequestDto.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException("Can't get dtos from file " + filePath, e);
        }
    }
}
