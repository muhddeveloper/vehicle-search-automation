package com.exercise.vehicle.search.automation.parsers.impl;

import com.exercise.vehicle.search.automation.model.Vehicle;
import com.exercise.vehicle.search.automation.parsers.IParser;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public class CSVParser implements IParser {

    private static final CsvParser parser;

    private static final BeanListProcessor<Vehicle> rowProcessor;

    static {
        rowProcessor = new BeanListProcessor<>(Vehicle.class);

        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);

        parser = new CsvParser(parserSettings);
    }

    public static void main(String[] args) {


        parser.parse(new File("D:/automation/file1.csv"));

        List<Vehicle> beans =
                rowProcessor.getBeans();
        System.out.println(beans);

        parser.parse(new File("D:/automation/file1.csv"));

        beans =
                rowProcessor.getBeans();
        System.out.println(beans);
    }

    @Override
    public List<Vehicle> parse(File file) {
        parser.parse(file);
        List<Vehicle> vehicles = rowProcessor.getBeans();
        return vehicles;
    }
}
