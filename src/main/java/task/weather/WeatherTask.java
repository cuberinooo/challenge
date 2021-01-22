package task.weather;

import io.CsvFileReader;
import io.FileReader;
import task.helper.TaskCalculator;
import task.helper.TaskConfig;

import java.util.HashMap;

public class WeatherTask {

    /**
     * @author Kubilay Anil <kubilay.anil@hotmail.com>
     * @since 2021-01-22
     */
    public String getDayWithSmallestTempSpread() {

        FileReader fileReader = new CsvFileReader();
        fileReader.setReader(TaskConfig.WEATHER_CSV_FILE_PATH);

        TaskCalculator taskCalculator = new TaskCalculator();

        HashMap<String, Integer> config = new HashMap<>();
        config.put(TaskConfig.OUTPUT_VALUE, 0);
        config.put(TaskConfig.MAX_VALUE, 1);
        config.put(TaskConfig.MIN_VALUE, 2);

        return taskCalculator.calcSmallestSpread(fileReader, true, config);

    }
}
