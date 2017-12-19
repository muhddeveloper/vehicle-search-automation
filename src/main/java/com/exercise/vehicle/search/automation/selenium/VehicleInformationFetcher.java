package com.exercise.vehicle.search.automation.selenium;

import com.exercise.vehicle.search.automation.constants.BaseConstants;
import com.exercise.vehicle.search.automation.constants.Browsers;
import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.Vehicle;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;

/**
 * Created by muhdk on 19/12/2017.
 */
public class VehicleInformationFetcher {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleInformationFetcher.class);


    private final WebDriver driver;

    public VehicleInformationFetcher(final Browsers browsers) {
        this.driver = DriverFactory.getDriver(browsers);

    }

    public void stopBrowser() {
        this.driver.quit();
    }


    public Vehicle getVehicleDetails(final String vehicleRegNumber) throws AutomationServiceException {

        try {

            LOG.info("Opening the page {}", BaseConstants.VEHICLE_URL);

            //go to the url
            driver.get(BaseConstants.VEHICLE_URL);

            //click Start now
            final WebElement startNowBtn = fluentWait(partialLinkText("Start now"));

            if (!startNowBtn.isDisplayed())
                throw new AutomationServiceException("Main page is not loaded properly");

            //click start now
            startNowBtn.click();

            //add search value
            fluentWait(id("Vrm")).sendKeys(vehicleRegNumber);

            //click search
            fluentWait(name("Continue")).click();

            //get the attributes
            fluentWait(className("list-summary-item"));

            final List<WebElement> summaryElements = driver.findElements(className("list-summary-item"));

            if (summaryElements == null || summaryElements.isEmpty()) {
                throw new AutomationServiceException("No data for the registration number:" + vehicleRegNumber);
            }
            final String make = summaryElements.get(1).findElements(tagName("span")).get(1).getText();
            final String color = summaryElements.get(2).findElements(tagName("span")).get(1).getText();

            LOG.info("Make found {}", make);
            LOG.info("Color found {}", color);

            return new Vehicle(vehicleRegNumber, color.trim(), make.trim());
        } catch (AutomationServiceException e) {
            throw e;

        }


    }


    /**
     * Smart way to wait for element to come
     * @param locator
     * @return
     */
    WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }

        });

        return foo;
    }

    ;
}
