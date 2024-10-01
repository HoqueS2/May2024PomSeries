package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();

	}
	
	
	public String getRandomEmail() {
		return "uiautomation"+System.currentTimeMillis()+"@open.com";
	}
	
	
	/*
	@Test
	public void userRegisterTest() {
		Assert.assertTrue(registerPage.userRegisteration("Veena", "automation", getRandomEmail(), "9876567654","veena@123", "yes"));

	}*/
	

	
	
	
	//************************* Assignment My contribution *********************************************
	
	
	
	@DataProvider
	public Object[][] getRegistrationData() {
		return new Object[][] {
			{"veena", "kumar","984789873","veeba90","veeba90"},
			{"Rima", "kumar","988889873","meeba90","meeba90"}
					
		};
	}
	
	
	
	@Test(dataProvider = "getRegistrationData")
	public void userRegisterTest(String firstName, String lastName,String telephone, String password, String confirmPass) {
		Assert.assertTrue(registerPage.userRegisteration(firstName, "lastName", getRandomEmail(), telephone,password, confirmPass));

	}

}
