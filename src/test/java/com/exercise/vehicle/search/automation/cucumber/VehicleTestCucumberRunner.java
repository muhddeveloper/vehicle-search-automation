package com.exercise.vehicle.search.automation.cucumber;

import org.junit.runner.RunWith;
 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        format = {

                "html:target/cucumber/vehicle-search.html",
                "pretty"
        }
)
public class VehicleTestCucumberRunner {
}