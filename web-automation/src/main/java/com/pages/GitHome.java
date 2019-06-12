package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHome {


	WebDriver driver;


	By homePageTitle = By.xpath("//*[@class=\"h000-mktg text-white lh-condensed-ultra mb-3\"]");
	By signIn = By.linkText("Sign in");
	public GitHome(WebDriver driver){

		this.driver = driver;

	}

	//Get git welcome title from Home Page

	public String getHomePageTitle(){

		return    driver.findElement(homePageTitle).getText();

	}
	public void clickSignIn(){

		driver.findElement(signIn).click();

	}

}
