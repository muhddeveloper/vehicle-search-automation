package com.exercise.vehicle.search.automation.parsers.impl;

import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.Vehicle;
import com.exercise.vehicle.search.automation.parsers.IParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public class ExcelParserTest {

    @Test
    public void test_parseExcel() throws AutomationServiceException {
        IParser parser = new ExcelParser();
        final List<Vehicle> vehicles = parser.parse(new File(ExcelParserTest.class.getResource("/file1.xlsx").getPath()));
        Assert.assertNotNull(vehicles);
        Assert.assertTrue(vehicles.size() == 1);

        Assert.assertNotNull(vehicles.get(0).getRegistrationNumber());
        Assert.assertNotNull(vehicles.get(0).getColor());
        Assert.assertNotNull(vehicles.get(0).getMake());


    }


}
