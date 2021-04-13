package org.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice extends BaseClass {

	@BeforeMethod
	private void beforeMethod() {
		getDriver();
		launchUrl("https://www.amazon.in/");
	}
	
	@AfterMethod
	private void afterMethod() {
		driver.close();
	}

	@Test(dataProvider = "product")
	private void travelPlan(String product) {
		WebElement search = locatorById("twotabsearchtextbox");
		insertValues(search, product);
		WebElement btnSearch = locatorById("nav-search-submit-button");
		click(btnSearch);
	}	
	
	@DataProvider(name ="product")
	public Object[][] plan(){
		return new Object[][] {
			{"iphone"},{"oneplus"},{"men's casual shoes"},{"men's casual shirts"}
	};
	}
}
