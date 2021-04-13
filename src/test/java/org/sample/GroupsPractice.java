package org.sample;

import java.awt.AWTException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupsPractice extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		getDriver();
		launchUrl("https://www.flipkart.com/");
	}

//	@AfterClass
//	private void afterClass() {
//		quit();
//	}

	@Test(groups = { "smoke" })
	private void tc2() {
		WebElement txtEmail = locatorByXpath("//input[@class='_2IX_2- VJZDxU']");
		insertValues(txtEmail, "ganeshkarthik.gk25@gmail.com");
		WebElement txtPass = locatorByXpath("//input[@class='_2IX_2- _3mctLh VJZDxU']");
		insertValues(txtPass, "Sanjay@4196");
		WebElement btnLogin = locatorByXpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
		click(btnLogin);
		implicitlyWait(5000);
	}

	@Test(groups = { "smoke" })
	private void tc3() throws AWTException {
		WebElement searchBox = locatorByName("q");
		insertValues(searchBox, "iphone 11");
		searchEnter();
	}

}
