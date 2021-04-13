package org.auto.sample;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BlazeDemoAutomation extends BaseClass {

	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;

	@BeforeClass
	private void beforeClass() {
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("blazedemo-extentreport.html");
		reports.attachReporter(htmlReporter);
		getDriver();
	}

	@AfterClass
	private void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		quit();
		reports.flush();
	}

	@AfterMethod
	private void afterMethod(Method m) throws IOException {
		screenShot(m.getName());
	}

	@Test
	private void tc0() throws IOException {
		test = reports.createTest("Url Check");
		launchUrl("https://blazedemo.com/");
		
		test.log(Status.INFO, "Given url is correct or not");
		if (driver.getCurrentUrl().contains("blazedemo")) {
			test.log(Status.PASS, "Url given is correct and valid");
			screenshotCopy("webpage.png");
			test.addScreenCaptureFromPath("webpage.png");
		} else {
			test.log(Status.FAIL, "Url given is not correct and not valid");
		}
	}

	@Parameters({ "fromPlace", "toPlace" })
	@Test
	private void tc1(String fromPlace, String toPlace) throws IOException {
		test = reports.createTest("Location Check");
		screenshotCopy("beforeFillingLocationPage.png");
		test.addScreenCaptureFromPath("beforeFillingLocationPage.png");
		
		TravelLocations t = new TravelLocations();
		test.log(Status.INFO, "Check whether from webelement is enabled and displayed");
		WebElement from = t.getFrom();
		if (from.isEnabled() && from.isDisplayed()) {
			test.log(Status.PASS, "From webelement is enabled and displayed");
			File screenshotAs = from.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("fromElement.png"));
			test.addScreenCaptureFromPath("fromElement.png");
		} else {
			test.log(Status.FAIL, "From webelement is not enabled and not displayed");
		}
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(from, fromPlace);
		if (from.getAttribute("value").equals(fromPlace)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = from.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("fromValues.png"));
			test.addScreenCaptureFromPath("fromValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		test.log(Status.INFO, "Check whether to webelement is enabled and displayed");
		WebElement to = t.getTo();
		if (to.isEnabled() && to.isDisplayed()) {
			test.log(Status.PASS, "To webelement is enabled and displayed");
			File screenshotAs = to.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("toElement.png"));
			test.addScreenCaptureFromPath("toElement.png");
		} else {
			test.log(Status.FAIL, "To webelement is not enabled and not displayed");
		}
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(to, toPlace);
		if (to.getAttribute("value").contains(toPlace)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = to.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("toValues.png"));
			test.addScreenCaptureFromPath("toValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		test.log(Status.INFO, "Check whether to webelement is enabled and displayed");
		WebElement find = t.getFind();
		if (find.isEnabled() && find.isDisplayed()) {
			test.log(Status.PASS, "Find webelement is enabled and displayed");
			File screenshotAs = find.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("findElement.png"));
			test.addScreenCaptureFromPath("findElement.png");
		} else {
			test.log(Status.FAIL, "Find webelement is not enabled and not displayed");
		}
		screenshotCopy("locationPage.png");
		test.addScreenCaptureFromPath("locationPage.png");
		click(find);
	}

	@Test
	private void tc2() {
		TableDatas d = new TableDatas();
		WebElement flight = d.getFlight();
		click(flight);
	}

	@Parameters({ "name", "address", "city", "state", "zipcode", "cardtype", "ccno", "month", "year", "cardname" })
	@Test
	private void tc3(String Name, String Address, String City, String State, String Zipcode, String Cardtype,
			String CCNo, String Month, String Year, String NameOnCard) throws IOException {
		test = reports.createTest("Booking Details Check");
		screenshotCopy("beforeFillingDetailsPage.png");
		test.addScreenCaptureFromPath("beforeFillingDetailsPage.png");
		
		BookingDetails b = new BookingDetails();
		test.log(Status.INFO, "Check whether name webelement is enabled and displayed");
		WebElement name = b.getName();
		if (name.isEnabled() && name.isDisplayed()) {
			test.log(Status.PASS, "Name webelement is enabled and displayed");
			File screenshotAs = name.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("nameElement.png"));
			test.addScreenCaptureFromPath("nameElement.png");
		} else {
			test.log(Status.FAIL, "Name webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(name, Name);
		if (name.getAttribute("value").contains(Name)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = name.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("nameValues.png"));
			test.addScreenCaptureFromPath("nameValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether address webelement is enabled and displayed");
		WebElement address = b.getAddress();
		if (address.isEnabled() && address.isDisplayed()) {
			test.log(Status.PASS, "Address webelement is enabled and displayed");
			File screenshotAs = address.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("addressElement.png"));
			test.addScreenCaptureFromPath("addressElement.png");
		} else {
			test.log(Status.FAIL, "Address webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(address, Address);
		if (address.getAttribute("value").contains(Address)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = address.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("addressValues.png"));
			test.addScreenCaptureFromPath("addressValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether city webelement is enabled and displayed");
		WebElement city = b.getCity();
		if (city.isEnabled() && city.isDisplayed()) {
			test.log(Status.PASS, "City webelement is enabled and displayed");
			File screenshotAs = city.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("cityElement.png"));
			test.addScreenCaptureFromPath("cityElement.png");
		} else {
			test.log(Status.FAIL, "City webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(city, City);
		if (city.getAttribute("value").contains(City)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = city.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("cityValues.png"));
			test.addScreenCaptureFromPath("cityValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether state webelement is enabled and displayed");
		WebElement state = b.getState();
		if (state.isEnabled() && state.isDisplayed()) {
			test.log(Status.PASS, "State webelement is enabled and displayed");
			File screenshotAs = state.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("stateElement.png"));
			test.addScreenCaptureFromPath("stateElement.png");
		} else {
			test.log(Status.FAIL, "State webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(state, State);
		if (state.getAttribute("value").contains(State)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = state.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("stateValues.png"));
			test.addScreenCaptureFromPath("stateValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether zipcode webelement is enabled and displayed");
		WebElement zipcode = b.getZipcode();
		if (zipcode.isEnabled() && zipcode.isDisplayed()) {
			test.log(Status.PASS, "Zipcode webelement is enabled and displayed");
			File screenshotAs = zipcode.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("zipElement.png"));
			test.addScreenCaptureFromPath("zipElement.png");
		} else {
			test.log(Status.FAIL, "Zipcode webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(zipcode, Zipcode);
		if (zipcode.getAttribute("value").contains(Zipcode)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = zipcode.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("zipValues.png"));
			test.addScreenCaptureFromPath("zipValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether cardtype webelement is enabled and displayed");
		WebElement cardtype = b.getCardtype();
		if (cardtype.isEnabled() && cardtype.isDisplayed()) {
			test.log(Status.PASS, "Cardtype webelement is enabled and displayed");
			File screenshotAs = cardtype.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("cardTypeElement.png"));
			test.addScreenCaptureFromPath("cardTypeElement.png");
		} else {
			test.log(Status.FAIL, "Cardtype webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(cardtype, Cardtype);
		
		test.log(Status.INFO, "Check whether ccno webelement is enabled and displayed");
		WebElement ccno = b.getCcno();
		if (ccno.isEnabled() && ccno.isDisplayed()) {
			test.log(Status.PASS, "CCNo webelement is enabled and displayed");
			File screenshotAs = ccno.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("ccnoElement.png"));
			test.addScreenCaptureFromPath("ccnoElement.png");
		} else {
			test.log(Status.FAIL, "CCNo webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(ccno, CCNo);
		if (ccno.getAttribute("value").contains(CCNo)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = ccno.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("ccnoValues.png"));
			test.addScreenCaptureFromPath("ccnoValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether month webelement is enabled and displayed");
		WebElement month = b.getMonth();
		if (month.isEnabled() && month.isDisplayed()) {
			test.log(Status.PASS, "Month webelement is enabled and displayed");
			File screenshotAs = month.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("monthElement.png"));
			test.addScreenCaptureFromPath("monthElement.png");
		} else {
			test.log(Status.FAIL, "Month webelement is not enabled and not displayed");
		}
		month.clear();
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(month, Month);
		if (month.getAttribute("value").contains(Month)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = month.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("monthValues.png"));
			test.addScreenCaptureFromPath("monthValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether year webelement is enabled and displayed");
		WebElement year = b.getYear();
		if (year.isEnabled() && year.isDisplayed()) {
			test.log(Status.PASS, "Year webelement is enabled and displayed");
			File screenshotAs = year.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("yearElement.png"));
			test.addScreenCaptureFromPath("yearElement.png");
		} else {
			test.log(Status.FAIL, "Year webelement is not enabled and not displayed");
		}
		year.clear();
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(year, Year);
		if (year.getAttribute("value").contains(Year)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = year.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("yearValues.png"));
			test.addScreenCaptureFromPath("yearValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether nameOnCard webelement is enabled and displayed");
		WebElement nameOnCard = b.getNameOnCard();
		if (nameOnCard.isEnabled() && nameOnCard.isDisplayed()) {
			test.log(Status.PASS, "NameOnCard webelement is enabled and displayed");
			File screenshotAs = nameOnCard.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("nameOnCardElement.png"));
			test.addScreenCaptureFromPath("nameOnCardElement.png");
		} else {
			test.log(Status.FAIL, "NameOnCard webelement is not enabled and not displayed");
		}
		
		test.log(Status.INFO, "Check whether required values are passed");
		insertValues(nameOnCard, NameOnCard);
		if (nameOnCard.getAttribute("value").contains(NameOnCard)) {
			test.log(Status.PASS, "Required value have been entered");
			File screenshotAs = nameOnCard.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("nameOnCardValues.png"));
			test.addScreenCaptureFromPath("nameOnCardValues.png");
		} else {
			test.log(Status.FAIL, "Required value is not entered");
		}
		
		test.log(Status.INFO, "Check whether purchase webelement is enabled and displayed");
		WebElement purchase = b.getPurchase();
		if (purchase.isEnabled() && purchase.isDisplayed()) {
			test.log(Status.PASS, "Purchase webelement is enabled and displayed");
			File screenshotAs = purchase.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("purchaseElement.png"));
			test.addScreenCaptureFromPath("purchaseElement.png");
		} else {
			test.log(Status.FAIL, "Purchase webelement is not enabled and not displayed");
		}
		screenshotCopy("detailsPage.png");
		test.addScreenCaptureFromPath("detailsPage.png");
		click(purchase);
	}

	@Test
	private void tc4() throws IOException {
		test = reports.createTest("Booking Confirmation Check");
		screenshotCopy("orderIdPage.png");
		test.addScreenCaptureFromPath("orderIdPage.png");
		
		WebElement orderId = locatorByXpath("//div//table//tbody//tr[1]//td[2]");
		String value = orderId.getText();
		System.out.println("\nOrder id for flight booking: " + value);
	}

}
