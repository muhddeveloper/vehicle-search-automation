package com.exercise.vehicle.search.automation.cucumber;

import com.exercise.vehicle.search.automation.constants.Browsers;
import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.Vehicle;
import com.exercise.vehicle.search.automation.selenium.VehicleInformationFetcher;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by muhdk on 19/12/2017.
 */
public class VehicleSearchSteps {

    private Vehicle vehicle;
    private VehicleInformationFetcher vehicleInformationFetcher;

    @Given("^I have valid car registration number$")
    public void new_vehicle_search() {
        vehicleInformationFetcher = new VehicleInformationFetcher(Browsers.FIREFOX);
        vehicle = new Vehicle();

    }

    @When("^Car registration number is \"([^\\\"]*)\"$")
    public void search_car_with_registration(String carNumber) throws AutomationServiceException {
        vehicle = vehicleInformationFetcher.getVehicleDetails(carNumber);

    }

    @Then("^The result should have Car Color \"(\\w+)\" and Car Make \"(\\w+)\"")
    public void car_search_should_be_correct_make_color(String color, final String make) {


        Assert.assertTrue(this.vehicle.getColor().equals(color.trim()));
        Assert.assertTrue(this.vehicle.getMake().equals(make.trim()));
    }

    @Given("^Close the browser$")
    public void close_browser() {
        vehicleInformationFetcher.stopBrowser();
        this.vehicle = null;

    }
}
