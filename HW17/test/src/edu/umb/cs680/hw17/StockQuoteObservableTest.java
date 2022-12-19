package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockQuoteObservableTest {

	@Test
	void checkDijaQuote() {
		LinechartObserver LinechartObserver = new LinechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		StockQuoteObservable djiaObserver = new StockQuoteObservable();
		djiaObserver.addObserver(LinechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);
// randomly changing quote to notifiy the observer
		djiaObserver.changeQuote("ASHIL",55);
		djiaObserver.changeQuote("JARVIS",75);
	}
}

