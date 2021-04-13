package org.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation extends BaseClass {
	
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")	WebElement orderNo;
	@FindBy(id="logout")	WebElement logoutBtn;
	
	public WebElement getOrderNo() {
		return orderNo;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
}
