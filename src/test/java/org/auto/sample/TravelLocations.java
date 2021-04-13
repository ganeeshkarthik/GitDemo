package org.auto.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelLocations extends BaseClass {

	public TravelLocations() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "fromPort")
	private WebElement from;

	@FindBy(name = "toPort")
	private WebElement to;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement find;

	public WebElement getFrom() {
		return from;
	}

	public WebElement getTo() {
		return to;
	}

	public WebElement getFind() {
		return find;
	}

}
