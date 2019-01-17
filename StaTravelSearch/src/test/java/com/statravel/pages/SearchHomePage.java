package com.statravel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchHomePage {
	
	WebDriver driver;
	
	public SearchHomePage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this); 
    }
		
	@FindBy(how = How.ID, using = "sta-cookie-save-all-button")
    private WebElement cookieButton;
	
	@FindBy(how = How.CSS, using = "div.sta-sw-landscape-row.sta-sw-tours-where>div>input[class*='sta-tour-search-text']")
	public WebElement selectDestination;
			
	@FindBy(how = How.CSS, using = "div.sta-standardSearch.sta-qbtb_tours > form > fieldset.sta-submit.sta-contain > p > button")
	public WebElement findATourButton;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='ui-id-18']//a[@class='ui-corner-all']")
	public List<WebElement> populatedCountries;
	
	public void clickAcceptCookieButton() {
		 cookieButton.click();
	}
	 
	 public void enterDestintion(String country) throws InterruptedException {
		 selectDestination.sendKeys(country);
		 Thread.sleep(1000);
	 }
	 
	 public void clickFindATourButton() {
		 findATourButton.click();
	 }
	 
	 public void selectAutoSuggestOption(String selectTour) throws InterruptedException {
	 	List<WebElement> optionsToSelect = driver.findElements(By.tagName("li"));
		for(WebElement option : optionsToSelect){
		    if(option.getText().equals(selectTour)) {
		        System.out.println("Trying to select: "+selectTour);
		        option.click();
		        break;
		    }
		}
	}
	 
	 public boolean isDestinationDisplayed(){
			return selectDestination.isDisplayed();
		}

	public boolean isFindATourButtonEnabled() {
		return findATourButton.isEnabled();
	}
	
}