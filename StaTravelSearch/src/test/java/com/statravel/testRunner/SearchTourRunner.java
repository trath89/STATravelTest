package com.statravel.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src//test//resources//features//Statravel.feature",
		glue = "com.statravel.stepDefinition" ,
		plugin="html:target//cucumber_html_Report/"
		)

public class SearchTourRunner {

}