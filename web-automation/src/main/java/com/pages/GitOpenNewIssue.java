package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitOpenNewIssue {

	WebDriver driver;
	By newIssueOpen = By.xpath("(//a[@class])[39]");

	public GitOpenNewIssue(WebDriver driver){

		this.driver = driver;

	}

	public String getOpenIssuePageTitle(){

		return    driver.findElement(newIssueOpen).getText();

	}

}
