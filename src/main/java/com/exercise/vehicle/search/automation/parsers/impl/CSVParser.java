package com.exercise.vehicle.search.automation.parsers.impl;

import com.exercise.vehicle.search.automation.model.Vehicle;
import com.exercise.vehicle.search.automation.parsers.IParser;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public class CSVParser implements IParser {

    private static final Logger LOG = LoggerFactory.getLogger(CSVParser.class);

    private static final CsvParser parser;

    private static final BeanListProcessor<Vehicle> rowProcessor;

    static {

        LOG.info("Init CSV Parser");
        rowProcessor = new BeanListProcessor<>(Vehicle.class);

        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);

        parser = new CsvParser(parserSettings);
    }


    public List<Vehicle> parse(File file) {
        LOG.info("Parsing CSV File {}", file);
        parser.parse(file);
        List<Vehicle> vehicles = rowProcessor.getBeans();

        LOG.debug("Vehicles {}", vehicles);
        return vehicles;
    }
}
