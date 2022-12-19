package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Chebyshev;

public class ChebyshevTest {

	@Test
	public void distanceTestWithP1P2() {
		List<Double> p1 = Arrays.asList(1.0, 4.0, 7.0);
		List<Double> p2 = Arrays.asList(2.0, 5.0, 9.0);
		double expected = 2;
		double actual = new Chebyshev().distance(p1, p2);
		assertEquals(expected, actual);
	}
}
