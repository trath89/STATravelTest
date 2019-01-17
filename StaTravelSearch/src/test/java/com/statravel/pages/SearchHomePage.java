package com.statravel.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHomePage {
	
	public SearchHomePage(WebDriver driver) {
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
	 
	 public void enterDestintion(String country) {
		 selectDestination.sendKeys(country);
	 }
	 
	 public void clickFindATourButton() throws InterruptedException {
		 Thread.sleep(200);
		 findATourButton.click();
	 }
	 
	 public void selectAutoSuggestOption(String selectTour) throws InterruptedException {
		List<WebElement> elements = populatedCountries;
		if (elements != null) {
			for (Iterator<WebElement> webElement = elements.iterator(); webElement.hasNext();) {
				WebElement item = webElement.next();
				if (item.getText().equals(selectTour)) {
					Thread.sleep(500);
					item.click();
					break;
				}
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