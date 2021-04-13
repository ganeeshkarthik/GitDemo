package org.sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RerunAndExtentReport extends BaseClass {

	ExtentReports report;
	ExtentHtmlReporter htmlReport;
	ExtentTest extentTest;

	@BeforeClass
	private void beforeMethod() {
		report = new ExtentReports();
		htmlReport = new ExtentHtmlReporter("extentreport.html");
		report.attachReporter(htmlReport);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterClass
	private void afterMethod() {
		quit();
		report.flush();
	}

	@Test
	private void tc() {
		extentTest = report.createTest("Open AdactIn Webpage");
		extentTest.log(Status.INFO, "Check whether correct url is given");
		launchUrl("http://adactinhotelapp.com/");
		if (driver.getCurrentUrl().contains("adactinhotelapp")) {
			extentTest.log(Status.PASS, "Given url is correct");
		} else {
			extentTest.log(Status.FAIL, "Given url is not correct");
		}
	}

	@Test
	private void tc0() throws IOException {
		extentTest = report.createTest("Login into AdactIn Application");
		LoginPage lp = new LoginPage();
		WebElement txtUsername = lp.getTxtUsername();
		extentTest.log(Status.INFO, "Check whether username webelement is enabled and displayed");
		if (txtUsername.isEnabled() && txtUsername.isDisplayed()) {
			extentTest.log(Status.PASS, "Username webelement is enabled and displayed");
			File screenshotAs = txtUsername.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("enabledusername.png"));
			extentTest.addScreenCaptureFromPath("enabledusername.png");
		} else {
			extentTest.log(Status.FAIL, "Username webelement is not-enabled and not-displayed");
			File screenshotAs = txtUsername.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("disabledusername.png"));
			extentTest.addScreenCaptureFromPath("disabledusername.png");
		}
		extentTest.log(Status.INFO, "Is given username is valid");
		txtUsername.sendKeys("ganeeshkarthik");
		if (txtUsername.getAttribute("value").equals("ganeeshkarthik")) {
			extentTest.log(Status.PASS, "Given username value is correct");
			File screenshotAs = txtUsername.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("validusername.png"));
			extentTest.addScreenCaptureFromPath("validusername.png");
		} else {
			extentTest.log(Status.FAIL, "Given username value is incorrect");
			File screenshotAs = txtUsername.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("invalidusername.png"));
			extentTest.addScreenCaptureFromPath("invalidusername.png");
		}
		WebElement txtPassword = lp.getTxtPassword();
		extentTest.log(Status.INFO, "Check whether password webelement is enabled and displayed");
		if (txtPassword.isEnabled() && txtPassword.isDisplayed()) {
			extentTest.log(Status.PASS, "Password webelement is enabled and displayed");
			File screenshotAs = txtPassword.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("enabledpassword.png"));
			extentTest.addScreenCaptureFromPath("enabledpassword.png");
		} else {
			extentTest.log(Status.FAIL, "Password webelement is not-enabled and not-displayed");
			File screenshotAs = txtPassword.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("disabledpassword.png"));
			extentTest.addScreenCaptureFromPath("disabledpassword.png");
		}
		txtPassword.sendKeys("Sanjay@4196");
		if (txtPassword.getAttribute("value").equals("Sanjay@4196")) {
			extentTest.log(Status.PASS, "Given password value is correct");
			File screenshotAs = txtPassword.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("validpassword.png"));
			extentTest.addScreenCaptureFromPath("validpassword.png");
		} else {
			extentTest.log(Status.FAIL, "Given password value is incorrect");
			File screenshotAs = txtPassword.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("invalidpassword.png"));
			extentTest.addScreenCaptureFromPath("invalidpassword.png");
		}
		WebElement btnLogin = lp.getBtnLogin();
		extentTest.log(Status.INFO, "Check whether login webelement is enabled and displayed");
		if (btnLogin.isEnabled() && btnLogin.isDisplayed()) {
			extentTest.log(Status.PASS, "Login webelement is enabled and displayed");
			File screenshotAs = btnLogin.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("enabledlogin.png"));
			extentTest.addScreenCaptureFromPath("enabledlogin.png");
		} else {
			extentTest.log(Status.FAIL, "Login webelement is not-enabled and not-displayed");
			File screenshotAs = btnLogin.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("disabledlogin.png"));
			extentTest.addScreenCaptureFromPath("disabledlogin.png");
		}
		btnLogin.click();
	}

	@Test
	private void tc1() throws IOException {
		extentTest = report.createTest("Hotel booking based on required conditions");
		HotelBooking h = new HotelBooking();
		WebElement location = h.getLocation();
		extentTest.log(Status.INFO, "Check whether location webelement is enabled and displayed");
		if (location.isEnabled() && location.isDisplayed()) {
			extentTest.log(Status.PASS, "Location webelement is enabled and displayed");
			File screenshotAs = location.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("enabledlocation.png"));
			extentTest.addScreenCaptureFromPath("enabledlocation.png");
		} else {
			extentTest.log(Status.FAIL, "Location webelement is not enabled and displayed");
			File screenshotAs = location.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("disabledlocation.png"));
			extentTest.addScreenCaptureFromPath("disabledlocation.png");
		}
		selectByIndex(location, 2);
		extentTest.log(Status.INFO, "Check whether correct option is seected");
		
		if (location.getAttribute("value").equalsIgnoreCase("melbourne")) {
			extentTest.log(Status.PASS, "Required location is selected");
			File screenshotAs = location.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File("selectedlocation.png"));
			extentTest.addScreenCaptureFromPath("selectedlocation.png");
		} else {
			extentTest.log(Status.FAIL, "Required location is not selected");
		}
		
		
		WebElement hotel = h.getHotel();
		selectByIndex(hotel, 2);
		WebElement roomType = h.getRoomType();
		selectByIndex(roomType, 3);
		WebElement rooms = h.getRooms();
		selectByIndex(rooms, 2);
		WebElement checkInDate = h.getCheckInDate();
		checkInDate.clear();
		checkInDate.sendKeys("20/04/2021");
		WebElement checkOutDate = h.getCheckOutDate();
		checkOutDate.clear();
		checkOutDate.sendKeys("21/04/2021");
		WebElement adultRooms = h.getAdultRooms();
		selectByIndex(adultRooms, 2);
		WebElement childRoom = h.getChildRoom();
		selectByIndex(childRoom, 1);
		WebElement submitBtn = h.getSubmitBtn();
		submitBtn.click();
	}

	@Test
	private void tc2() {
		SelectHotel s = new SelectHotel();
		WebElement radioBtn = s.getRadioBtn();
		click(radioBtn);
		WebElement continueBtn = s.getContinueBtn();
		click(continueBtn);
	}

	@Test
	private void tc3() {
		DetailsPage d = new DetailsPage();
		WebElement firstName = d.getFirstName();
		insertValues(firstName, "Ganeesh");
		WebElement lastName = d.getLastName();
		insertValues(lastName, "Karthik");
		WebElement address = d.getAddress();
		insertValues(address, "Chennai");
		WebElement creditCardNo = d.getCreditCardNo();
		insertValues(creditCardNo, "8765432112345678");
		WebElement ccType = d.getCcType();
		selectByIndex(ccType, 2);
		WebElement expMonth = d.getExpMonth();
		selectByIndex(expMonth, 5);
		WebElement expYear = d.getExpYear();
		selectByIndex(expYear, 7);
		WebElement ccvNo = d.getCcvNo();
		insertValues(ccvNo, "4321");
		WebElement bookNowBtn = d.getBookNowBtn();
		click(bookNowBtn);
	}

	@Test
	private void tc4() {
		BookingConfirmation b = new BookingConfirmation();
		WebElement orderNo = b.getOrderNo();
		String value = getValue(orderNo);
		System.out.println("Booking order number is " + value);
		WebElement logoutBtn = b.getLogoutBtn();
		click(logoutBtn);
	}

}
