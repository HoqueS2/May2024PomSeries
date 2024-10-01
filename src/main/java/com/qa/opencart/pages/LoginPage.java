package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators: page objects
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By logo = By.cssSelector("img.img-responsive");
	private By headermanu = By.xpath("//nav[@id='menu']//ul[@class='nav navbar-nav']/li/a");

	// 2. Public Page Const...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Methods
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title: " + title);
		return title;
	}
	
	public List<String> getLoginPageHeaderManu() {
		List<WebElement> headerList = driver.findElements(headermanu);
		List<String> headersValueList = new ArrayList<String>();
		System.out.println("-------------------------------- ");
		System.out.println(headerList.size());
		System.out.println("LoginPage Header Manu List Are: ");

		for (WebElement e : headerList) {
			String text = e.getText();
			headersValueList.add(text);
			System.out.println(text);
		}
		System.out.println("-------------------------------- ");
		return headersValueList;
	}
	
	@Step("getting login page url value")
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title: " + url);
		return url;
	}
	
	@Step("checking isForgotPwdLink exist on the login page....")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);		
	}
	
	@Step("checking logo exist on the login page....")
	public boolean isLogoExist() {
		return eleUtil.isElementDisplayed(logo);		
	}
	
	@Step("login with username : {0} and password: {1}")
	public AccountsPage doLogin(String userName, String pwd) {
		System.out.println("creds are: " + userName + " : " + pwd);
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);	
	}
	
	@Step("navigating to regiter page")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
	

}

