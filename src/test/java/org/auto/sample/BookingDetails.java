package org.auto.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingDetails extends BaseClass {

	public BookingDetails() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputName")
	private WebElement name;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "state")
	private WebElement state;

	@FindBy(id = "zipCode")
	private WebElement zipcode;

	@FindBy(id = "cardType")
	private WebElement cardtype;

	@FindBy(id = "creditCardNumber")
	private WebElement ccno;

	@FindBy(id = "creditCardMonth")
	private WebElement month;

	@FindBy(id = "creditCardYear")
	private WebElement year;

	@FindBy(id = "nameOnCard")
	private WebElement nameOnCard;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement purchase;

	public WebElement getPurchase() {
		return purchase;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getCcno() {
		return ccno;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getNameOnCard() {
		return nameOnCard;
	}

}
