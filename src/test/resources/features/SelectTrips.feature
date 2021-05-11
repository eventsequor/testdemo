# language: en
@smoke
Feature: Select of the trips
  I want to test the process to choose a trip

  Background: Set actor
    Given the actor "traveler" go to the main page

  @SelectOutboundTrip
  Scenario: Choose the trip alone outbound
    Given the origin "Medellín" and the destination "Cartagena"
    And the number of adults 2 children 1 and babies 1
    When selecting options for the current day's flight
    Then validate which number of options to select is greater than 11
