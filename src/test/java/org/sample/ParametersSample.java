package org.sample;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersSample extends BaseClass {

	@BeforeClass
	private void beforeClass() throws IOException {
		getDriver();
		launchUrl("http://adactinhotelapp.com/");
		screenShot("launchPage");
	}

	@AfterClass
	private void afterClass() {
		quit();
	}

	@Parameters({ "username", "password" })
	@Test(priority = 1)
	private void hotelBooking(String username, String password) throws IOException, InterruptedException {
		LoginPage lp = new LoginPage();
		WebElement txtUsername = lp.getTxtUsername();
		txtUsername.sendKeys(username);
		WebElement txtPassword = lp.getTxtPassword();
		txtPassword.sendKeys(password);
		screenShot("loginDetails");
		Thread.sleep(2000);
		WebElement btnLogin = lp.getBtnLogin();
		btnLogin.click();
	}

	@Parameters({ "checkIn", "checkOut" })
	@Test(priority = 2)
	private void hotelSearch(String checkIn, String checkOut) {
		HotelBooking h = new HotelBooking();
		WebElement location = h.getLocation();
		selectByIndex(location, 2);
		WebElement hotel = h.getHotel();
		selectByIndex(hotel, 2);
		WebElement roomType = h.getRoomType();
		selectByIndex(roomType, 3);
		WebElement rooms = h.getRooms();
		selectByIndex(rooms, 2);
		WebElement checkInDate = h.getCheckInDate();
		checkInDate.clear();
		checkInDate.sendKeys(checkIn);
		WebElement checkOutDate = h.getCheckOutDate();
		checkOutDate.clear();
		checkOutDate.sendKeys(checkOut);
		WebElement adultRooms = h.getAdultRooms();
		selectByIndex(adultRooms, 2);
		WebElement childRoom = h.getChildRoom();
		selectByIndex(childRoom, 1);
		WebElement submitBtn = h.getSubmitBtn();
		submitBtn.click();
	}

	@Test(priority = 3)
	private void selectHotel() {
		SelectHotel s = new SelectHotel();
		WebElement radioBtn = s.getRadioBtn();
		click(radioBtn);
		WebElement continueBtn = s.getContinueBtn();
		click(continueBtn);
	}

	@Parameters({ "firstname", "lastname", "Address", "creditcardno", "cvvno" })
	@Test(priority = 4)
	private void detailsPage(String firstname, String lastname, String Address, String creditcardno, String cvvno)
			throws InterruptedException {
		DetailsPage d = new DetailsPage();
		WebElement firstName = d.getFirstName();
		insertValues(firstName, firstname);
		WebElement lastName = d.getLastName();
		insertValues(lastName, lastname);
		WebElement address = d.getAddress();
		insertValues(address, Address);
		WebElement creditCardNo = d.getCreditCardNo();
		insertValues(creditCardNo, creditcardno);
		WebElement ccType = d.getCcType();
		selectByIndex(ccType, 2);
		WebElement expMonth = d.getExpMonth();
		selectByIndex(expMonth, 5);
		WebElement expYear = d.getExpYear();
		selectByIndex(expYear, 7);
		WebElement ccvNo = d.getCcvNo();
		insertValues(ccvNo, cvvno);
		WebElement bookNowBtn = d.getBookNowBtn();
		click(bookNowBtn);
		Thread.sleep(10000);
	}

	@Test(priority = 5)
	private void bookingConfirm() {
		BookingConfirmation b = new BookingConfirmation();
		WebElement orderNo = b.getOrderNo();
		String value = getValue(orderNo);
		System.out.println("\nBooking order number is " + value);
		WebElement logoutBtn = b.getLogoutBtn();
		click(logoutBtn);
	}

//	@BeforeMethod
//	private void beforeMethod(Method method) throws IOException {
//		Date date = new Date();
//		System.out.println(date);
//	}

	@AfterMethod
	private void afterMethod(Method method) throws IOException {
		screenShot(method.getName());
		Date date = new Date();
		System.out.println(date);
	}

}