package com.test.avianca.test.tata.userinterfaces;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ChooseFlights extends PageObject {
	public static final Target AVAILABLE_FLIGHTS = Target.the("Vuelos disponibles")
			.locatedBy("//*[contains(@class,'bound-expander')]");
}
