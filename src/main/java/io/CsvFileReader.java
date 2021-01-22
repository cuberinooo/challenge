package io;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class CsvFileReader implements FileReader {

    CSVReader csvReader;

    @Override
    public void setReader(String path) {
        try {
            URL resource = getClass().getClassLoader().getResource(path);
            File file = Paths.get(resource.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();

            this.csvReader = new CSVReader(new java.io.FileReader((absolutePath)));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Could not open file in Path: " + path + " due to error: " + fileNotFoundException.getMessage());
        } catch (URISyntaxException uriSyntaxException) {
            System.out.println("Illegal character: " + uriSyntaxException);
        }
    }

    @Override
    public String[] readNext() {

        String[] line = null;
        try {
            line = this.csvReader.readNext();
        } catch (IOException | CsvValidationException e) {
            System.out.println("Could not read line due to error: " + e.getMessage());
        }
        return line;
    }

}
