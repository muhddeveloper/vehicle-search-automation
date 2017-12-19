package com.exercise.vehicle.search.automation.model;

import com.univocity.parsers.annotations.Parsed;

/**
 * Created by muhdk on 19/12/2017.
 */
public class Vehicle {

    @Parsed(index = 0)
    private String registrationNumber;
    @Parsed(index = 1)
    private String color;
    @Parsed(index = 2)
    private String make;

    public Vehicle() {
    }

    public Vehicle(String registrationNumber, String color, String make) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.make = make;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                '}';
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
