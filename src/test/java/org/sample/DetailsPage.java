package org.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage extends BaseClass{
	
	public DetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")	WebElement firstName;
	@FindBy(id="last_name")		WebElement lastName;
	@FindBy(id="address")		WebElement address;
	@FindBy(id="cc_num")		WebElement creditCardNo;
	@FindBy(id="cc_type")		WebElement ccType;
	@FindBy(id="cc_exp_month")	WebElement expMonth;
	@FindBy(id="cc_exp_year")	WebElement expYear;
	@FindBy(id="cc_cvv")		WebElement ccvNo;
	@FindBy(id="book_now")		WebElement bookNowBtn;
	
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditCardNo() {
		return creditCardNo;
	}
	public WebElement getCcType() {
		return ccType;
	}
	public WebElement getExpMonth() {
		return expMonth;
	}
	public WebElement getExpYear() {
		return expYear;
	}
	public WebElement getCcvNo() {
		return ccvNo;
	}
	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}
	
}
