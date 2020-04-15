package org.venturatravel.runners;

import cucumber.api.CucumberOptions;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ServiceTemplate.feature",
        glue = "org.venturatravel.stepdefinitions/"
)
public class Runner {

}






