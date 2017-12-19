package com.exercise.vehicle.search.automation.parsers;

import com.exercise.vehicle.search.automation.constants.MimeTypes;
import com.exercise.vehicle.search.automation.parsers.impl.CSVParser;
import com.exercise.vehicle.search.automation.parsers.impl.ExcelParser;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.Validate;

/**
 * Created by muhdk on 19/12/2017.
 */
public class ParserFactory {

    private static final CSVParser CSV_PARSER = new CSVParser();
    private static final ExcelParser EXCEL_PARSER = new ExcelParser();


    public static IParser getParser(final String fileName) {
        Validate.notNull(fileName, "File name required");

        final String extension = FilenameUtils.getExtension(fileName);
        if (Lists.newArrayList(MimeTypes.CSV.getExtensions()).contains(extension)) {
            return CSV_PARSER;
        }

        if (Lists.newArrayList(MimeTypes.EXCEL.getExtensions()).contains(extension)) {
            return EXCEL_PARSER;
        }

        return null;

    }
}
