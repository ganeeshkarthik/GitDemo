package org.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBooking extends BaseClass {

	public HotelBooking() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(id = "location"), @FindBy(name = "location") })
	WebElement location;

	@FindBy(id = "hotels")
	WebElement hotel;

	@FindBy(id = "room_type")
	WebElement roomType;

	@FindBy(id = "room_nos")
	WebElement rooms;
	@FindBy(id = "datepick_in")
	WebElement checkInDate;
	@FindBy(id = "datepick_out")
	WebElement checkOutDate;
	@FindBy(id = "adult_room")
	WebElement adultRooms;
	@FindBy(id = "child_room")
	WebElement childRoom;
	@FindBy(id = "Submit")
	WebElement submitBtn;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultRooms() {
		return adultRooms;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

}
