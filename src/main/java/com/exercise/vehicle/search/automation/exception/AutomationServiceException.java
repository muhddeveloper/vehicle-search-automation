package com.exercise.vehicle.search.automation.exception;

/**
 * Created by muhdk on 19/12/2017.
 */
public class AutomationServiceException extends  Exception {


    public AutomationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutomationServiceException(String message) {
        super(message);
    }
}
