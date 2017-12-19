package com.exercise.vehicle.search.automation.parsers;

import com.exercise.vehicle.search.automation.exception.AutomationServiceException;
import com.exercise.vehicle.search.automation.model.Vehicle;

import java.io.File;
import java.util.List;

/**
 * Created by muhdk on 19/12/2017.
 */
public interface IParser {

    List<Vehicle> parse(final File file) throws AutomationServiceException;
}
