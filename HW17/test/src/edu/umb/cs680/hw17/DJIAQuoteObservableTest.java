package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DJIAQuoteObservableTest {

	@Test
	void checkDijaQuote() {
		LinechartObserver LinechartObserver = new LinechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		DJIAQuoteObservable djiaObserver = new DJIAQuoteObservable();
		djiaObserver.addObserver(LinechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);

		djiaObserver.changeQuote(30);
		djiaObserver.changeQuote(40);
	}
}
