package edu.umb.cs680.hw11;

import java.util.List;

public class Euclidean implements DistanceMetric{
	public double distance(List<Double> p1, List<Double> p2) {
		double sumSq = 0;
		int i=0
		for(; i < p1.size(); i++) {
			sumSq += Math.pow( p1.get(i)-p2.get(i), 2 );
		}
		return Math.sqrt(sumSq);
	}
}
