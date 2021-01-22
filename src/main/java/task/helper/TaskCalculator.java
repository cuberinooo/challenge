package task.helper;

import io.FileReader;

import java.util.HashMap;

public class TaskCalculator {

    public String calcSmallestSpread(FileReader csvReader, boolean skipFirstRow, HashMap<String, Integer> config) {

        int tmpLowestSpread = TaskConfig.STARTING_VALUE;
        String tmpLowestSpreadOutputValue = String.valueOf(TaskConfig.STARTING_VALUE);

        String[] nextLine;

        while ((nextLine = csvReader.readNext()) != null) {

            if (skipFirstRow) {
                skipFirstRow = false;
            } else {

                String outputValue = String.valueOf(nextLine[config.get(TaskConfig.OUTPUT_VALUE)]);
                int max = Integer.parseInt(nextLine[config.get(TaskConfig.MAX_VALUE)]);
                int min = Integer.parseInt(nextLine[config.get(TaskConfig.MIN_VALUE)]);

                int diffMaxMin = Math.abs(max - min);

                if (tmpLowestSpread == TaskConfig.STARTING_VALUE || tmpLowestSpread > diffMaxMin) {
                    tmpLowestSpread = diffMaxMin;
                    tmpLowestSpreadOutputValue = outputValue;
                }
            }
        }

        return tmpLowestSpreadOutputValue;

    }

}
