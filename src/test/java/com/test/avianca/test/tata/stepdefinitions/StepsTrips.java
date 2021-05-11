package com.test.avianca.test.tata.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

import com.test.avianca.test.tata.exceptions.NotFindFlightsException;
import com.test.avianca.test.tata.models.TripInformation;
import com.test.avianca.test.tata.questions.NumberAvailableFligths;
import com.test.avianca.test.tata.task.ChooseTravel;
import com.test.avianca.test.tata.userinterfaces.HomeAvianca;

import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

public class StepsTrips {
	private TripInformation tripInfo;

	@Before
	public void preconditions() {
		setTheStage(new OnlineCast());
	}

	@Given("the actor {string} go to the main page")
	public void the_actor_go_to_the_main_page(String nameActor) {
		theActorCalled(nameActor);
		theActorInTheSpotlight().wasAbleTo(Open.browserOn(new HomeAvianca()));
	}

	@Given("the origin {string} and the destination {string}")
	public void the_origin_and_the_destination(String origin, String destination) {
		tripInfo = new TripInformation(origin, destination);
	}

	@Given("the number of adults {int} children {int} and babies {int}")
	public void the_number_of_adults_children_and_babies(Integer adultsNumber, Integer childrensNumber,
			Integer babiesNumber) {
		tripInfo.setAdultsNumber(adultsNumber);
		tripInfo.setChildrensNumber(childrensNumber);
		tripInfo.setBabiesNumber(babiesNumber);
	}

	@When("selecting options for the current day's flight")
	public void selecting_options_for_the_current_day_s_flight() {
		theActorInTheSpotlight().attemptsTo(ChooseTravel.selectTrip(tripInfo));
	}

	@Then("validate which number of options to select is greater than {int}")
	public void validate_which_number_of_options_to_select_is_greater_than_zero(Integer numberOptions) {
		theActorInTheSpotlight()
				.should(GivenWhenThen.seeThat(NumberAvailableFligths.getNumberFlights(), equalTo(numberOptions))
						.orComplainWith(NotFindFlightsException.class,
								"El número de vuelos disponibles no corresponde con el número de vuelos esperado"));
	}

	@After
	public void posconditions() {
		BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().quit();
	}
}
