package task.weather;

import io.CsvFileReader;
import io.FileReader;

public class WeatherTask {

    public static final int STARTING_VALUE = -1;

    public int getDayWithSmallestTempSpread() {

        int tmpLowestSpread = WeatherTask.STARTING_VALUE;
        int tmpLowestSpreadDay = WeatherTask.STARTING_VALUE;

        try {

            FileReader fileReader = new CsvFileReader();
            fileReader.setReader(WeatherCsvConfig.WEATHER_CSV_FILE_PATH);

            String[] nextLine;

            boolean firstRow = true;

            while ((nextLine = fileReader.readNext()) != null) {

                if (firstRow) {
                    firstRow = false;
                } else {
                    int day = Integer.parseInt(nextLine[WeatherCsvConfig.DAY_NUMBER]);
                    int mxt = Integer.parseInt(nextLine[WeatherCsvConfig.MAX_TEMPERATURE]);
                    int mnt = Integer.parseInt(nextLine[WeatherCsvConfig.MIN_TEMPERATURE]);

                    int diffMxtMnt = Math.abs(mxt - mnt);

                    if (tmpLowestSpread == WeatherTask.STARTING_VALUE || tmpLowestSpread > diffMxtMnt) {
                        tmpLowestSpread = diffMxtMnt;
                        tmpLowestSpreadDay = day;
                    }
                }
            }

        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        return tmpLowestSpreadDay;

    }
}
