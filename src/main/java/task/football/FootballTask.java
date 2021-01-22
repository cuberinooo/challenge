package task.football;

import io.CsvFileReader;
import io.FileReader;
import task.helper.TaskCalculator;
import task.helper.TaskConfig;

import java.util.HashMap;

public class FootballTask {

    /**
     * @author  Kubilay Anil <kubilay.anil@hotmail.com>
     * @since   2021-01-22
     */
    public String getTeamWithSmallestGoalSpread() {

        FileReader fileReader = new CsvFileReader();
        fileReader.setReader(TaskConfig.FOOTBALL_CSV_FILE_PATH);

        TaskCalculator taskCalculator = new TaskCalculator();

        HashMap<String, Integer> config = new HashMap<>();
        config.put(TaskConfig.OUTPUT_VALUE, 0);
        config.put(TaskConfig.MAX_VALUE, 5);
        config.put(TaskConfig.MIN_VALUE, 6);

        return taskCalculator.calcSmallestSpread(fileReader, true, config);
    }

}
