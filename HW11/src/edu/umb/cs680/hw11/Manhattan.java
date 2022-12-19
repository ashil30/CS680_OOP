package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric {

	public double distance(List<Double> p1, List<Double> p2) {
		double sumCoord = 0;
		int i = 0;
		for (;i < p1.size(); i++) {
			sumCoord += Math.abs(p1.get(i) - p2.get(i));
		}
		return sumCoord;
	}

}
