package org.auto.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableDatas extends BaseClass {

	public TableDatas() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@class='btn btn-small'])[3]")
	private WebElement flight;

	public WebElement getFlight() {
		return flight;
	}
}
