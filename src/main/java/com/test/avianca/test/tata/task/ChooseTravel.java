package com.test.avianca.test.tata.task;

import com.test.avianca.test.tata.interactions.SetTextAndSelectOption;
import com.test.avianca.test.tata.models.TripInformation;
import com.test.avianca.test.tata.userinterfaces.HomeAvianca;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ChooseTravel implements Task {
	private TripInformation tripInfo;

	public ChooseTravel(TripInformation tripInfo) {
		this.tripInfo = tripInfo;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(HomeAvianca.NAVBAR_RESERVA_TU_VUELO));
		actor.attemptsTo(Click.on(HomeAvianca.NAVBAR_SOLO_IDA));
		actor.attemptsTo(SetTextAndSelectOption.setText(HomeAvianca.INPUT_TEXT_DESDE, tripInfo.getOrigin()));
		actor.attemptsTo(SetTextAndSelectOption.setText(HomeAvianca.INPUT_TEXT_HACIA, tripInfo.getDestination()));
		actor.attemptsTo(Click.on(HomeAvianca.INPUT_TEXT_DEPARTURE_DATE));
		actor.attemptsTo(Click.on(HomeAvianca.OPTION_CURRENT_DATE));
		actor.attemptsTo(Click.on(HomeAvianca.PASSAENGERS));
		selectNumberPositions(actor, (tripInfo.getAdultsNumber() - 1), HomeAvianca.ADD_ADULTS);
		selectNumberPositions(actor, tripInfo.getChildrensNumber(), HomeAvianca.ADD_CHILDRENS);
		selectNumberPositions(actor, tripInfo.getBabiesNumber(), HomeAvianca.ADD_BABIES);
		actor.attemptsTo(Click.on(HomeAvianca.BUTTON_CONTINUAR_PASSAENGERS));
		actor.attemptsTo(Click.on(HomeAvianca.BUTTON_LOOKFOR_FLIGHTS));

	}

	public static ChooseTravel selectTrip(TripInformation tripInfo) {
		return Tasks.instrumented(ChooseTravel.class, tripInfo);
	}

	private void selectNumberPositions(Actor actor, Integer number, Target target) {
		if (number > 0) {
			for (int i = 0; i < number; i++) {
				actor.attemptsTo(Click.on(target));
			}
		} else {
			for (int i = 0; i < number; i++) {
				actor.attemptsTo(Click.on(target));
			}
		}
	}
}
