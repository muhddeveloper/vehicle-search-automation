package com.exercise.vehicle.search.automation.selenium;

import com.exercise.vehicle.search.automation.constants.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by muhdk on 19/12/2017.
 */
public class DriverFactory {

    public static WebDriver getDriver(final Browsers browsers) {
        if (browsers == Browsers.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", DriverFactory.class.getResource("/drivers/geckodriver.exe").getPath());
            return new FirefoxDriver();
        }
        if (browsers == Browsers.CHROME) {
            System.setProperty("webdriver.chrome.driver", VehicleInformationFetcher.class.getResource("/drivers/chromedriver.exe").getPath());
            return new ChromeDriver();
        }

        return null;
    }
}
