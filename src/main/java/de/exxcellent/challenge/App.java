package de.exxcellent.challenge;

import task.football.FootballTask;
import task.weather.WeatherTask;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        WeatherTask weatherTask = new WeatherTask();
        FootballTask footballTask = new FootballTask();

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", weatherTask.getDayWithSmallestTempSpread());

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", footballTask.getTeamWithSmallestGoalSpread());
    }
}
