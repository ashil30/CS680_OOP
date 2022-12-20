package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PriceComparatorTest {

	private static LinkedList<Car> cars = new LinkedList<Car>();

	private String[] CarToString(Car c) {
		String[] info = {c.getModel(), c.getMake(), Integer.toString(c.getYear()) , Float.toString(c.getPrice()), Integer.toString(c.getMileage())};
		return info;
	}

	@BeforeAll
	private static void setUpOfCars() {

		Car c1 = new Car("550i", "BMW", 2018, 17000, 1500);
		cars.add(c1);
		Car c2 = new Car("R8", "Audi", 2022, 24000, 4500);
		cars.add(c2);
		Car c3 = new Car("AVENTADOR", "Lamborghini", 2016, 9000, 7500);
		cars.add(c3);
		Car c4 = new Car("C Class", "Mercedes", 2014, 3000, 5500);
		cars.add(c4);
		Collections.sort(cars,(Car C1, Car C2) -> (int)C1.getPrice()-(int)C2.getPrice());
	}

	@Test
	public void testForFirstCar() {
		String[] expected = {"C Class", "Mercedes", "2014", "3000.0", "5500"};
		String[] actual = CarToString(cars.get(0));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testForSecondCar() {
		String[] expected = {"AVENTADOR", "Lamborghini", "2016", "9000.0", "7500"};
		String[] actual = CarToString(cars.get(1));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testForThirdCar() {
		String[] expected = {"550i", "BMW", "2018", "17000.0", "1500"};
		String[] actual = CarToString(cars.get(2));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testForFourthCar() {
		String[] expected = {"R8", "Audi", "2022", "24000.0", "4500"};
		String[] actual = CarToString(cars.get(3));
		assertArrayEquals(expected, actual);
	}
}