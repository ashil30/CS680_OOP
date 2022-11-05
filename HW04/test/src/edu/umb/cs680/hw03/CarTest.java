package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    private String[] carToStringArray(Car c) {
        String[] CarInfo = {c.getMake(), c.getModel(), Integer.toString(c.getYear())};
        return CarInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Mercedes", "C class", "2022"};
        Car actual = new Car("Mercedes", "C class", 2022);
        assertArrayEquals(expected, carToStringArray(actual));
    }

    @Test
    public void verifyNotEqualCarWithMakeModelYear() {
        String[] expected = {"Volvo", "S60", "2021"};
        Car actual = new Car("Jeep", "Cherokee", 2022);
        assertNotEquals(expected, carToStringArray(actual));
    }

}