package boot.project.demo.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {
    @CsvBindByName(column = "Id")
    private String id;
    @CsvBindByName(column = "ProductId")
    private String productId;
    @CsvBindByName(column = "UserId")
    private String userId;
    @CsvBindByName(column = "ProfileName")
    private String profileName;
    @CsvBindByName(column = "HelpfulnessNumerator")
    private String helpfulnessNumerator;
    @CsvBindByName(column = "HelpfulnessDenominator")
    private String helpfulnessDenominator;
    @CsvBindByName(column = "Score")
    private String score;
    @CsvBindByName(column = "Time")
    private String time;
    @CsvBindByName(column = "Summary")
    private String summary;
    @CsvBindByName(column = "Text")
    private String text;
}
