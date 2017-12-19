package com.exercise.vehicle.search.automation.parsers.impl;

import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.Vehicle;
import com.exercise.vehicle.search.automation.parsers.IParser;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public class ExcelParser implements IParser {

    private static final DataFormatter formatter = new DataFormatter();


    @Override
    public List<Vehicle> parse(File file) throws AutomationServiceException {
        Workbook workbook = null;
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            workbook = WorkbookFactory.create(file);

            final Sheet sheet = workbook.getSheetAt(0);
            int rowNum = 0;
            for (Row row : sheet) {

                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }
                String registrationNumber = formatter.formatCellValue(row.getCell(0));
                String color = formatter.formatCellValue(row.getCell(1));
                String make = formatter.formatCellValue(row.getCell(2));

                vehicles.add(new Vehicle(registrationNumber, color, make));


            }


        } catch (Exception e) {
            throw new AutomationServiceException("Error reading the file:" + file, e);
        } finally {
            if (workbook != null)
                try {
                    workbook.close();
                } catch (IOException e) {
                    //ignore
                }
        }

        return vehicles;

    }
}

