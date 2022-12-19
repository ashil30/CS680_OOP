package edu.umb.cs680.hw17;




public class DJIAQuoteObservable extends Observable{
	
	float quote;
	void changeQuote(float q) {
		this.quote = q;
		notifyObservers(Double.valueOf(this.quote));
	}
	
	public static void main(String[] args) {
		System.out.println("The class DJIAQuoteObservable has run successfully");
	}
}
