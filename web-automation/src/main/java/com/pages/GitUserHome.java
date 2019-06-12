package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitUserHome {

	
WebDriver driver;

By newRepoBtn = By.xpath("(//a[@class])[27]");
By userPageTitle =By.xpath("(//h2[@class])[1]");

public GitUserHome(WebDriver driver){

    this.driver = driver;
}
public void clickNewRepo(){

    driver.findElement(newRepoBtn).click();

}
public String getUserHomeTitle() {
	// TODO Auto-generated method stub
	  return    driver.findElement(userPageTitle).getText();
}
}
