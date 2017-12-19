package com.exercise.vehicle.search.automation.parsers.impl;

import com.exercise.vehicle.search.automation.parsers.IParser;
import com.exercise.vehicle.search.automation.parsers.ParserFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by muhdk on 19/12/2017.
 */
public class ParserFactoryTest {

    @Test
    public void test_factory() {
        IParser parser = new ParserFactory().getParser("test.csv");
        Assert.assertTrue(parser instanceof CSVParser);

        parser = new ParserFactory().getParser("test.xls");
        Assert.assertTrue(parser instanceof ExcelParser);

        parser = new ParserFactory().getParser("test.xlsx");
        Assert.assertTrue(parser instanceof ExcelParser);


        parser = new ParserFactory().getParser("test.txt");
        Assert.assertTrue(parser==null);
    }
}
