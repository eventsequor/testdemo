package com.test.avianca.test.tata.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features",
glue = "com.test.avianca.test.tata.stepdefinitions",
monochrome = true,
plugin = {"pretty"}
)
public class RunnerTestTrip {

}
