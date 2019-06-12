package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitIssues {


	WebDriver driver;
	By issuesTab = By.cssSelector("#js-repo-pjax-container > div.pagehead.repohead.instapaper_ignore.readability-menu.experiment-repo-nav > nav > span:nth-child(2) > a");
By issuesTitle = By.cssSelector("#js-repo-pjax-container > div.container.new-discussion-timeline.experiment-repo-nav > div.repository-content > div > div.Box > div > h3");
	public GitIssues(WebDriver driver){

		this.driver = driver;

	}
	public WebElement getIssueTab(){

	return    driver.findElement(issuesTab);

	}
	public String getIssueTitle(){

		return    driver.findElement(issuesTitle).getText();

	}
	private void clickIssueTab(){

		driver.findElement(issuesTab).click();

	}
	public void startIssueTab() {
		this.getIssueTab();
		this.clickIssueTab();
	}


}
