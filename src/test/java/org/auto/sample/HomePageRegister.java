package org.auto.sample;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageRegister extends BaseClass {

	public HomePageRegister() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='home']")
	private WebElement home;

	public WebElement getHome() {
		return home;
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement register;

	public WebElement getRegister() {
		return register;
	}

	@FindBy(id = "name")
	private WebElement name;

	public WebElement getName() {
		return name;
	}

	@FindBy(id = "company")
	private WebElement company;

	public WebElement getCompany() {
		return company;
	}

	@FindBy(id = "email")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(id = "password-confirm")
	private WebElement confirmPassword;

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement btnRegister;

	public WebElement getBtnRegister() {
		return btnRegister;
	}

}
