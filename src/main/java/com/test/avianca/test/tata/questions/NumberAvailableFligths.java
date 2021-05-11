package com.test.avianca.test.tata.questions;

import com.test.avianca.test.tata.userinterfaces.ChooseFlights;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class NumberAvailableFligths implements Question<Integer> {
	private Integer numberOptions;

	@Override
	public Integer answeredBy(Actor actor) {
		numberOptions = Text.of(ChooseFlights.AVAILABLE_FLIGHTS).asAList().answeredBy(actor).size();
		System.out.println("number here ->> " + numberOptions);
		return numberOptions;
	}

	public static NumberAvailableFligths getNumberFlights() {
		return new NumberAvailableFligths();
	}

	public Integer getNumberOptions() {
		return numberOptions;
	}
}
