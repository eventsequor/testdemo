package com.test.avianca.test.tata.userinterfaces;

import java.util.Date;

import org.openqa.selenium.By;

import com.ibm.icu.text.SimpleDateFormat;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.avianca.com/co/es/")
public class HomeAvianca extends PageObject {
	public static final Target NAVBAR_RESERVA_TU_VUELO = Target.the("Reserva tú vuelo")
			.located(By.id("reservatuvuelo"));
	public static final Target NAVBAR_SOLO_IDA = Target.the("Solo ida")
			.locatedBy("//div[@class=\"innertab-control-general\"]//a[contains(text(),'Solo ida')]");
	public static final Target INPUT_TEXT_DESDE = Target.the("Desde").locatedBy(
			"(//div[contains(@class,'city-paddingNoMulti')]//label[contains(text(),'Desde')]//input[@data-name='pbOrigen'])[position()=2]");
	public static final Target INPUT_TEXT_HACIA = Target.the("Hacia").locatedBy(
			"(//div[contains(@class,'city-paddingNoMulti')]//label[contains(text(),'Hacia')]//input[@data-name='pbDestino'])[position()=2]");
	public static final Target INPUT_TEXT_DEPARTURE_DATE = Target.the("DEPARTURE DATE")
			.locatedBy("(//input[@name='pbFechaIda'])[position()=2]");
	public static final Target GRID_DATE = Target.the("Grip date")
			.locatedBy("//div[contains(@class,'calendar-container hidden-xs right new-calendar-pos calendar-home')]");

	public static final Target PASSAENGERS = Target.the("Pasajeros y clase").locatedBy(
			"(//*[@class='innertab-control-general' and not(@id='tabs')]//input[@name='pbPasajeros'])[position()=3]");

	public static final Target ADD_ADULTS = Target.the("(+) adults")
			.locatedBy("(//div[@class='controls adults']//*[@class='plus control'])[position()=2]");

	public static final Target SUBTRACT_ADULTS = Target.the("(-) adults")
			.locatedBy("(//div[@class='controls adults']//*[@class='minus control'])[position()=2]");

	public static final Target SUBTRACT_CHILDRENS = Target.the("(+) adults")
			.locatedBy("(//div[@class='controls noadults']//div[@class='minus control'])[position()=5]");

	public static final Target ADD_CHILDRENS = Target.the("(-) adults")
			.locatedBy("(//div[@class='controls noadults']//div[@class='plus control'])[position()=5]");

	public static final Target SUBTRACT_BABIES = Target.the("(+) adults")
			.locatedBy("(//div[@class='controls noadults']//div[@class='minus control'])[position()=6]");

	public static final Target ADD_BABIES = Target.the("(-) adults")
			.locatedBy("(//div[@class='controls noadults']//div[@class='plus control'])[position()=6]");

	public static final Target BUTTON_LOOKFOR_FLIGHTS = Target.the("Buscar vuelos").locatedBy(
			"(//button[contains(text(),'Buscar vuelos') and @class='btn primary btn-codepromo pull-btn rojo'])[position()=2]");

	public static final Target BUTTON_CONTINUAR_PASSAENGERS = Target.the("Continuar")
			.locatedBy("//*[@class='passenger float']//button");

	public static final Target OPTION_CURRENT_DATE = getCurrentDate();

	public static Target getCurrentDate() {
		String xpath = GRID_DATE.getCssOrXPathSelector() + "//div[@class='number-days']//td[@data-date='"
				+ currentDate() + "']";
		return Target.the("current date").locatedBy(xpath);
	}

	private static String currentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());
	}
}
