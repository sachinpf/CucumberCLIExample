package com.myOrg.Steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyTestSteps {

    private Scenario scenario;

    @Before("@MyTest")
    public void setMyScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^this is my first scenario$")
    public void this_is_my_first_scenario() {
        System.out.println("This is my first scenario.");
        scenario.log("This is my first scenario.");
    }

    @Given("^this is my second scenario$")
    public void this_is_my_second_scenario() {
        System.out.println("Saying - Hi");
        scenario.log("Saying - Hi");
    }

    @Then("^just say hi$")
    public void just_say_hi() {
        System.out.println("This is my second scenario.");
        scenario.log("This is my second scenario.");
    }

    @Then("^just say bye$")
    public void just_say_bye() {
        System.out.println("Saying - Bye");
        scenario.log("Saying - Bye");
    }
}
