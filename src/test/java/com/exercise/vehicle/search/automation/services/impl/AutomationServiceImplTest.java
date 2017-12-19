package com.exercise.vehicle.search.automation.services.impl;

import com.exercise.vehicle.search.automation.constants.MimeTypes;
import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.FileDetail;
import com.exercise.vehicle.search.automation.services.IAutomationService;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public class AutomationServiceImplTest {

    @Test
    public void test_scanDirectory() throws IOException, AutomationServiceException {
        IAutomationService automationService = new AutomationServiceImpl();
        final List<FileDetail> fileDetails = automationService.scanDirectory(AutomationServiceImplTest.class.getResource("/test").getPath());

        Assert.assertTrue(fileDetails.size() == 10);

        Assert.assertTrue(fileDetails.get(0).getFileName().equals("airport_details.txt"));
    }

    @Test
    public void test_retrieveFiles_CSV() throws IOException, AutomationServiceException {
        IAutomationService automationService = new AutomationServiceImpl();
        final List<File> files = automationService.retrieveFiles(AutomationServiceImplTest.class.getResource("/test").getPath(), MimeTypes.CSV);

        Assert.assertTrue(files.size() == 1);
        Assert.assertTrue(files.get(0).getName().equals("file1.csv"));
    }

    @Test
    public void test_retrieveFiles_Excel() throws IOException, AutomationServiceException {
        IAutomationService automationService = new AutomationServiceImpl();
        final List<File> files = automationService.retrieveFiles(AutomationServiceImplTest.class.getResource("/test").getPath(), MimeTypes.EXCEL);

        Assert.assertTrue(files.size() == 2);
        Assert.assertTrue(files.get(0).getName().equals("file1.xls"));
        Assert.assertTrue(files.get(1).getName().equals("file1.xlsx"));
    }

    @Test
    public void test_retrieveFiles_BOTH() throws IOException, AutomationServiceException {
        IAutomationService automationService = new AutomationServiceImpl();
        final List<File> files = automationService.retrieveFiles(
                AutomationServiceImplTest.class.getResource("/test").getPath(), MimeTypes.EXCEL, MimeTypes.CSV);

        Assert.assertTrue(files.size() == 3);

    }
}
