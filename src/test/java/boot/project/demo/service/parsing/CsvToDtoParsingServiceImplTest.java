package boot.project.demo.service.parsing;

import boot.project.demo.dto.ReviewRequestDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvToDtoParsingServiceImplTest {
    private static final String FILE_TEST_OK = "src/test/resources/test_dto_ok.csv";
    private static final String FILE_TEST_EMPTY_FILE = "src/test/resources/test_empty_file.csv";
    private static final String FILE_TEST_NO_FILE = "C::/docs";
    private static final List<ReviewRequestDto> expectedReviewDto = List.of(
            ReviewRequestDto.builder()
            .id("1")
            .productId("B001E4KFG0")
            .userId("A3SGXH7AUHU8GW")
            .profileName("delmartian")
            .helpfulnessNumerator("1")
            .helpfulnessDenominator("1")
            .score("5")
            .time("1303862400")
            .summary("Good Quality Dog Food")
            .text("I have bought several of the Vitality canned dog food products and have "
                    + "found them all to be of good quality. The product looks more like a stew"
                    + " than a processed meat and it smells better. My Labrador is finicky and "
                    + "she appreciates this product better than  most.")
            .build(),
            ReviewRequestDto.builder()
                    .id("2")
                    .productId("B00813GRG4")
                    .userId("A1D87F6ZCVE5NK")
                    .profileName("dll pa")
                    .helpfulnessNumerator("0")
                    .helpfulnessDenominator("0")
                    .score("1")
                    .time("1346976000")
                    .summary("Not as Advertised")
                    .text("Product arrived labeled as Jumbo Salted Peanuts...the peanuts "
                            + "were actually small sized unsalted. Not sure if this was an "
                            + "error or if the vendor intended to represent the product "
                            + "as \"Jumbo\".")
                    .build()
    );
    private static FileToDataParsingService<ReviewRequestDto> fileToDataParsingService;

    @BeforeAll
    public static void getParsingService() {
        fileToDataParsingService = new CsvToDtoParsingServiceImpl();
    }

    @Test
    public void parseTest_Ok() {
        List<ReviewRequestDto> actual = fileToDataParsingService.parse(FILE_TEST_OK);
        Assertions.assertEquals(expectedReviewDto, actual);
    }

    @Test
    public void parseTestEmptyFile() {
        List<ReviewRequestDto> expectedEmpty = new ArrayList<>();
        List<ReviewRequestDto> actual = fileToDataParsingService.parse(FILE_TEST_EMPTY_FILE);
        Assertions.assertEquals(expectedEmpty, actual);
    }

    @Test
    public void parseTestNoFile() {
        Assertions.assertThrows(RuntimeException.class,
                () -> fileToDataParsingService.parse(FILE_TEST_NO_FILE));
    }
}
