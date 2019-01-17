package com.statravel.stepDefinition;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.statravel.configs.Driver;
import com.statravel.pages.SearchHomePage;
import com.statravel.pages.SearchResultsPage;
import com.statravel.util.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchTourStepDefinition {

	public static WebDriver driver;
	
	SearchHomePage searchHomepage;
	
	SearchResultsPage searchResultsPage;
	
	@Given("^User is in STATravel website \"([^\"]*)\"$")
	public void user_is_in_STATravel_website(String url) throws Throwable {
		driver = Driver.initialize("chrome");
		driver.get(url);
		driver.manage().window().maximize();
		searchHomepage = new SearchHomePage(driver);
		Assert.assertEquals(driver.getTitle().toString(), "Worldwide Tours | STA Travel");
		Assert.assertTrue(searchHomepage.isDestinationDisplayed());
	}

	@When("^User select country \"([^\"]*)\"$")
	public void user_select_country(String country) throws Throwable {
		searchHomepage.clickAcceptCookieButton();
		searchHomepage.enterDestintion(country);
		Thread.sleep(300);
		searchHomepage.selectAutoSuggestOption(country);
		Assert.assertTrue(searchHomepage.isFindATourButtonEnabled());
	}

	@When("^User clicks on Find a Tour button$")
	public void user_clicks_on_Find_a_Tour_button() throws Throwable {
		searchHomepage.clickFindATourButton();
	}

	@Then("^User lands on results page$")
	public void user_lands_on_results_page() throws Throwable {
		String currentUrl = getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://tours.statravel.co.uk/search?Query=countries"));
	}

	@Given("^User is in results page$")
	public void user_is_in_results_page() throws Throwable {
		String currentUrl = getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("India"));
		searchResultsPage = new SearchResultsPage(driver);
	}
	
	@When("^User change the sort order to \"([^\"]*)\"$")
	public void user_change_the_sort_order_to(String sortBy) throws Throwable {
		searchResultsPage.selectSortBy(sortBy);
		Assert.assertEquals(searchResultsPage.getSortByText(), sortBy);
	}

	@When("^User clicks on View More button to display more/all results$")
	public void user_clicks_on_View_More_button_to_display_more_all_results()
			throws Throwable {
		searchResultsPage.clickOnViewMore();
		Assert.assertFalse(searchResultsPage.isViewMoreDisplayed());
	}

	@Then("^Verify the total matches found text is equal to the actual number of results displayed$")
	public void verify_the_total_matches_found_text_is_equal_to_the_actual_number_of_results_displayed()
			throws Throwable {
		
	}
	@Then("^Verify if \"([^\"]*)\" matches found text is equal to the actual number of results displayed$")
	public void verify_if_matches_found_text_is_equal_to_the_actual_number_of_results_displayed(int expectedResult) throws Throwable {
		int actualResult = searchResultsPage.countListOfProduct();
		Assert.assertEquals(actualResult, expectedResult);
		Utility.captureScreenshot(driver);
	}
	
	public String getCurrentUrl() {
		String currentUrl = null;
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> winHandle = winHandles.iterator(); 
		while (winHandle.hasNext()) { 
        	currentUrl = driver.switchTo().window(winHandle.next()).getCurrentUrl();
        } 
        return currentUrl;
	}

}
