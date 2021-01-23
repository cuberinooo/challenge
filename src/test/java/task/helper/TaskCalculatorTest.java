package task.helper;

import io.CsvFileReader;
import io.FileReader;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaskCalculatorTest {

    /**
     * @author Kubilay Anil <kubilay.anil@hotmail.com>
     * @since 2021-01-22
     */
    @Test
    public void testCalcSmallestSpreadGetSmallestSpread() {

        String expected = "Chelsea";

        TaskCalculator taskCalculator = new TaskCalculator();
        FileReader fileReader = mock(CsvFileReader.class);

        when(fileReader.readNext()).thenReturn(new String[]{"Arsenal", "38", "26", "9", "3", "79", "36", "87"},
                new String[]{"Chelsea", "38", "17", "13", "8", "66", "60", "64"}, null);

        HashMap<String, Integer> config = new HashMap<>();
        config.put(TaskConfig.OUTPUT_VALUE, 0);
        config.put(TaskConfig.MAX_VALUE, 5);
        config.put(TaskConfig.MIN_VALUE, 6);

        String result = taskCalculator.calcSmallestSpread(fileReader, false, config);

        assertEquals(result, expected);

    }

    /**
     * @author Kubilay Anil <kubilay.anil@hotmail.com>
     * @since 2021-01-22
     *
     * There are no requirements defined for this case, so the return value is the first day or team with the smallest spread
     */
    @Test
    public void testCalcSmallestSpreadWithSameSpread() {

        String expected = "1";

        TaskCalculator taskCalculator = new TaskCalculator();
        FileReader fileReader = mock(CsvFileReader.class);

        when(fileReader.readNext()).thenReturn(new String[]{"1", "88", "59", "74", "53.8", "0", "280", "9.6", "270", "17", "1.6", "93", "23", "1004.5"},
                new String[]{"2", "88", "59", "71", "46.5", "0", "330", "8.7", "340", "23", "3.3", "70", "28", "1004.5"}, null);

        HashMap<String, Integer> config = new HashMap<>();
        config.put(TaskConfig.OUTPUT_VALUE, 0);
        config.put(TaskConfig.MAX_VALUE, 1);
        config.put(TaskConfig.MIN_VALUE, 2);

        String result = taskCalculator.calcSmallestSpread(fileReader, false, config);

        assertEquals(result, expected);

    }


}
