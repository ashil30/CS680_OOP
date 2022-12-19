package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw12.Car;
import edu.umb.cs680.hw12.ParetoComparator;

public class ParetoComparatorTest {
	private static Car car1;
	private static Car car2;
	private static Car car3;
	private static LinkedList<Car> usedCars;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		usedCars = new LinkedList<>();
		Car car1 = new Car("Kia", "Abs", 90000, 2011, 8000.0f);
		Car car2 = new Car("Honda", "Jazz", 80000, 2010, 7000.0f);
		Car car3 = new Car("Chevrolet", "Uva", 50000, 2005, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
	}
	
	@Test
	public void dominationCountTestWithCar1() {
		int expected = 1;
		car1.setDominationCount(usedCars);
		int actual = car1.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountTestWithCar2() {
		int expected = 2;
		car2.setDominationCount(usedCars);
		int actual = car2.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountTestWithCar3() {
		int expected = 0;
		car3.setDominationCount(usedCars);
		int actual = car3.getDominationCount();
		assertEquals(expected, actual);
	}

	@Test
	public void dominationCountAscendingSortTest() {
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car1);
		expected.add(car2);
		car1.setDominationCount(usedCars);
		car2.setDominationCount(usedCars);
		car3.setDominationCount(usedCars);
		Collections.sort(usedCars, new ParetoComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

}
