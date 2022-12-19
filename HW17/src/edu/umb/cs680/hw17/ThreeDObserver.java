package edu.umb.cs680.hw17;


public class ThreeDObserver implements Observer{
	
	private String ticker;
	private double quote;
	
	public void update(Observable o, Object o1) {
		
		if(o instanceof StockQuoteObservable)
		{
			ticker = ((StockEvent)o1).getTicker();
			quote = ((StockEvent) o1).getQuote();
			System.out.println("\n 3DObserver Notified:\n Ticker: "+ticker+"\n Quote: "+quote+"\n");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("The class 3d observer has run successfully");
	}
}
