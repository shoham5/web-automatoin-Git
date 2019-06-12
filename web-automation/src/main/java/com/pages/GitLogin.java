package com.pages;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class GitLogin {

	WebDriver driver;

	By userGitName = By.name("login");

	By passwordGit = By.name("password");

	By login = By.name("commit");
	By titleText =By.xpath("//label[@for=\"login_field\"]");

	public GitLogin(WebDriver driver){

		this.driver = driver;

	}

	//Set user name in textbox

	private void setUserName(String strUserName){

		driver.findElement(userGitName).sendKeys(strUserName);

	}

	//Set password in password textbox

	private void setPassword(String strPassword){

		driver.findElement(passwordGit).sendKeys(strPassword);

	}

	//Click on login button

	private void clickLogin(){

		driver.findElement(login).click();

	}

	//Get the title of Login Page

	public String getLoginTitle(){

		return    driver.findElement(titleText).getText();

	}

	/**

	 * This POM method will be exposed in test case to login in the application

	 * @param strUserName

	 * @param strPasword

	 * @return

	 */

	public void loginToGit(String strUserName,String strPasword){

		//Fill user name

		this.setUserName(strUserName);

		//Fill password

		this.setPassword(strPasword);

		//Click Login button

		this.clickLogin();        
	}



}
