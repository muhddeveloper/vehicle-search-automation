package com.exercise.vehicle.search.automation.selenium;

import com.exercise.vehicle.search.automation.constants.Browsers;
import com.exercise.vehicle.search.automation.constants.MimeTypes;
import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.Vehicle;
import com.exercise.vehicle.search.automation.parsers.ParserFactory;
import com.exercise.vehicle.search.automation.services.impl.AutomationServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public class VehicleInformationFetcherTest {

    @Test
    public void test() throws AutomationServiceException, InterruptedException {

        final AutomationServiceImpl automationService = new AutomationServiceImpl();
        final List<File> files = automationService.retrieveFiles(VehicleInformationFetcher.class.getResource("/test").getPath(), MimeTypes.CSV, MimeTypes.EXCEL);

        final VehicleInformationFetcher vehicleInformationFetcher = new VehicleInformationFetcher(Browsers.FIREFOX);

        for (File file : files) {
            final List<Vehicle> vehicleList = ParserFactory.getParser(file.getName()).parse(file);

            for (Vehicle vehicle : vehicleList) {

                final Vehicle vehicleDetails = vehicleInformationFetcher.getVehicleDetails(vehicle.getRegistrationNumber());

                Assert.assertTrue(vehicleDetails.getMake().equals(vehicle.getMake()));
                Assert.assertTrue(vehicleDetails.getColor().equals(vehicle.getColor()));

                //wait for 1 seconds don't send too many request ot website
                Thread.sleep(1000);

            }


        }
        vehicleInformationFetcher.stopBrowser();


    }
}
