package com.statravel.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage {
	
	public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this); 
    }
	
	@FindBy(how = How.CSS, using = "#sortSelect")
	public WebElement sortByDropDown;

	@FindBy(how = How.CSS, using = "#btnViewMore")
	public WebElement viewMoreButton;

	@FindBy(how = How.CSS, using = "#products .trip-img-group")
	public List<WebElement> listOfProducts;

	@FindBy(how = How.XPATH, using = "//ul[@id='ui-id-18']//a[@class='ui-corner-all']")
	public List<WebElement> autoPopulatedList;
	
	public void selectSortBy(String sortByText) {
		new Select(sortByDropDown).selectByVisibleText(sortByText);
	}

	public void clickOnViewMore() {
		viewMoreButton.click();
	}

	public int countListOfProduct() {
		return listOfProducts.size();
	}
	
	public String getSortByText() {
		Select select = new Select(sortByDropDown);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isViewMoreDisplayed() {
		return viewMoreButton.isDisplayed();
	}


}
