package edu.umb.cs680.hw17;

import java.util.HashMap;
import java.util.Map;


public class StockQuoteObservable extends Observable{
	
	Map<String, Float> map = new HashMap<String, Float>();
	
	void changeQuote(String t,float q) {
		map.put(t, q);

		notifyObservers(new StockEvent(t,q));
	}
	
	public static void main(String[] args) {
		System.out.println("The class StockquoteObservable has run successfully");
	}
}
