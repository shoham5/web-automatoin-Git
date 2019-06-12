package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitWriteIssue {

	WebDriver driver;
	By pageTitle = By.xpath("(//a[@class])[32]");
	By issuesTitle =By.xpath("(//input[@type='text'])[4]");
	By commentArea = By.xpath("//textarea [@id='issue_body']");
	By submitIssueBtn =By.className("//button[@class='btn btn-primary']");
	
	public GitWriteIssue(WebDriver driver){

        this.driver = driver;

    }
	
	 private void clickSubmitIssue(){

         driver.findElement(submitIssueBtn).click();

 }
	 private void setCommentArea(String strComment){

	        driver.findElement(commentArea).sendKeys(strComment);

	    }

	    //Set Issue in titleIssue textbox

	 private void setIssueTitle(String strIssue){

	         driver.findElement(issuesTitle).sendKeys(strIssue);

	    }
	 public void createIssue(String strTitle,String strComment){

	        //Fill Issue title

	        this.setIssueTitle(strTitle);

	        //Fill Issue comment

	        this.setCommentArea(strComment);
        
	    }

	public String getIssueWriteTitle() {
		// TODO Auto-generated method stub
		  return    driver.findElement(pageTitle).getText();
	}
	
}
