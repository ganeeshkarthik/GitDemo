package org.sample;

import java.io.IOException;
import java.lang.reflect.Method;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertPractice extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		getDriver();
		launchUrl("http://adactinhotelapp.com/");
	}

	@AfterClass
	private void afterClass() {
		BookingConfirmation b = new BookingConfirmation();
		WebElement logoutBtn = b.getLogoutBtn();
		click(logoutBtn);
		quit();
	}

	@Test(priority=1)
	private void loginPage() {
		LoginPage lp = new LoginPage();
		WebElement txtUsername = lp.getTxtUsername();
		insertValues(txtUsername, "ganeeshkarthik");
		Assert.assertEquals("ganeeshkarthik", txtUsername.getAttribute("value"));
		WebElement txtPassword = lp.getTxtPassword();
		insertValues(txtPassword, "Sanjay@4196");
		Assert.assertEquals("Sanjay@4196", txtPassword.getAttribute("value"));
	}

	@Test(priority=2)
	private void hotelBooking() {
		LoginPage lp = new LoginPage();
		WebElement btnLogin = lp.getBtnLogin();
		btnLogin.click();
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
		insertValues(checkInDate, "10/04/2021");
		Assert.assertEquals("10/04/2021", checkInDate.getAttribute("value"));
		WebElement checkOutDate = h.getCheckOutDate();
		checkOutDate.clear();
		insertValues(checkOutDate, "11/04/2021");
		Assert.assertEquals("11/04/2021", checkOutDate.getAttribute("value"));
		WebElement adultRooms = h.getAdultRooms();
		selectByIndex(adultRooms, 2);
		WebElement childRoom = h.getChildRoom();
		selectByIndex(childRoom, 1);
	}

	@Test(priority=3)
	private void selectHotel() {
		HotelBooking h = new HotelBooking();
		WebElement submitBtn = h.getSubmitBtn();
		submitBtn.click();
		SelectHotel s = new SelectHotel();
		WebElement radioBtn = s.getRadioBtn();
		click(radioBtn);
	}

	@Test(priority=4)
	private void detailsPage() throws InterruptedException {
		SelectHotel s = new SelectHotel();
		WebElement continueBtn = s.getContinueBtn();
		click(continueBtn);
		DetailsPage d = new DetailsPage();
		WebElement firstName = d.getFirstName();
		insertValues(firstName, "Ganeesh");
		WebElement lastName = d.getLastName();
		insertValues(lastName, "Karthik");
		WebElement address = d.getAddress();
		insertValues(address, "Chennai");
		WebElement creditCardNo = d.getCreditCardNo();
		insertValues(creditCardNo, "1234567812348765");
		WebElement ccType = d.getCcType();
		selectByIndex(ccType, 2);
		WebElement expMonth = d.getExpMonth();
		selectByIndex(expMonth, 5);
		WebElement expYear = d.getExpYear();
		selectByIndex(expYear, 7);
		WebElement ccvNo = d.getCcvNo();
		insertValues(ccvNo, "4321");
		Thread.sleep(2000);
		Assert.assertEquals("Ganeesh", firstName.getAttribute("value"));
		Assert.assertEquals("Karthik", lastName.getAttribute("value"));
		Assert.assertEquals("Chennai", address.getAttribute("value"));
		Assert.assertEquals("1234567812348765", creditCardNo.getAttribute("value"));
		Assert.assertEquals("4321", ccvNo.getAttribute("value"));
	}

	@Test(priority=5)
	private void bookingConfirmation() {
		DetailsPage d = new DetailsPage();
		WebElement bookNowBtn = d.getBookNowBtn();
		click(bookNowBtn);
		implicitlyWait(100);
		BookingConfirmation b = new BookingConfirmation();
		WebElement orderNo = b.getOrderNo();
		String value = getValue(orderNo);
		System.out.println("\nBooking order number is " + value);
		WebElement orderScroll = locatorByXpath("//*[@id=\"order_no\"]");
		scrollDown(orderScroll);
	}

	@AfterMethod
	private void afterMethod(Method m) throws IOException {
		screenShot(m.getName());
	}

}
