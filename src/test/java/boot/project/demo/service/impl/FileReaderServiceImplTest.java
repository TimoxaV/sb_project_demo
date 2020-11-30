package boot.project.demo.service.impl;

import boot.project.demo.service.FileReaderService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileReaderServiceImplTest {
    private static final String FILE_PATH_OK = "src/test/resources/test_ok.csv";
    private static final String FILE_PATH_EMPTY_FILE = "src/test/resources/test_empty_file.csv";
    private static final String FILE_PATH_NO_FILE = "C::/docs";
    private static final List<String[]> TEST_OK = List.of(
            new String[]{"Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator",
                    "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"},
            new String[]{"1", "B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian", "1", "1", "5", "1303862400",
                    "Good Quality Dog Food", "I have bought several of the Vitality canned dog "
                    + "food products and have found them all to be of good quality. The product "
                    + "looks more like a stew than a processed meat and it smells better. My "
                    + "Labrador is finicky and she appreciates this product better than  most."},
            new String[]{"2", "B00813GRG4", "A1D87F6ZCVE5NK", "dll pa", "0", "0", "1", "1346976000",
                    "Not as Advertised",
                    "Product arrived labeled as Jumbo Salted Peanuts...the peanuts were actually "
                            + "small sized unsalted. Not sure if this was an error or if the vendor "
                            + "intended to represent the product as \"Jumbo\"."}
    );
    private static FileReaderService fileReaderService;

    @BeforeAll
    static void getFileReaderServiceImpl() {
        fileReaderService = new FileReaderServiceImpl();
    }

    @Test
    public void readFile_Ok() {
        List<String[]> actual = fileReaderService.readFile(FILE_PATH_OK);
        for (int i = 0; i < TEST_OK.size(); i++) {
            Assertions.assertArrayEquals(TEST_OK.get(i), actual.get(i));
        }
    }

    @Test
    public void readFileEmptyFile() {
        int expected = 0;
        List<String[]> actual = fileReaderService.readFile(FILE_PATH_EMPTY_FILE);
        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    public void readFileNoFile() {
        Assertions.assertThrows(RuntimeException.class,
                () -> fileReaderService.readFile(FILE_PATH_NO_FILE));
    }
}
