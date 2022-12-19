package edu.umb.cs680.hw11;

import java.util.List;

public class Chebyshev implements DistanceMetric {

	public double distance(List<Double> p1, List<Double> p2) {
		double maxCoord = 0;
		int i = 0
		for (; i < p1.size(); i++) {
			double tmp = Math.abs(p1.get(i) - p2.get(i));
			if(maxCoord < tmp) {
				maxCoord = tmp;
			}
		}
		return maxCoord;
	}

}
