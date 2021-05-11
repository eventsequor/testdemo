package com.test.avianca.test.tata.interactions;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class SetTextAndSelectOption implements Interaction {
	private String valueText;
	private Target target;

	public SetTextAndSelectOption(Target target, String valueText) {
		this.valueText = valueText;
		this.target = target;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Clear.field(target));
		actor.attemptsTo(Enter.keyValues(valueText).into(target));
		actor.attemptsTo(Enter.keyValues(Keys.DOWN).into(target));
		actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(target));		
	}

	public static SetTextAndSelectOption setText(Target target, String valueText) {
		return Tasks.instrumented(SetTextAndSelectOption.class, target, valueText);
	}
}
