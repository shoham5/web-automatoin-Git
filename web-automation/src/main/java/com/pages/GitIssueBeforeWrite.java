package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitIssueBeforeWrite {
	WebDriver driver;
	//By newIssueBtn =By.xpath("(//*[contains(@class,'btn-primary')])[2]");
	
	By issuesTitle = By.cssSelector("body > div.footer.container-lg.width-full.p-responsive > div.position-relative.d-flex.flex-row-reverse.flex-lg-row.flex-wrap.flex-lg-nowrap.flex-justify-center.flex-lg-justify-between.pt-6.pb-2.mt-6.f6.text-gray.border-top.border-gray-light > ul:nth-child(3) > li:nth-child(6) > a");
	
	public GitIssueBeforeWrite(WebDriver driver){

		this.driver = driver;
	}

	
	//public WebElement getIssueBtn(){

	//	return    driver.findElement(newIssueBtn);
//
	//	}
	
	public String getIssueTitle(){

		return    driver.findElement(issuesTitle).getText();

	}


	///public void clickNewIssueBtn() {
		// TODO Auto-generated method stub
	//	driver.findElement(newIssueBtn).click();
	//}
	

}
