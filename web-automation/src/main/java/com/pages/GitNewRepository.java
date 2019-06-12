package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitNewRepository {

	WebDriver driver;
	By repoTitle = By.xpath("(//h2[@class])[1]");
	By nameRepoFiled = By.xpath("(//input[@type='text'])[3]");
	By descRepoFiled = By.xpath("(//input[@type='text'])[4]");
	
	By createRepoBtn = By.xpath("//*[contains(@class,'primary first')]");


	public GitNewRepository(WebDriver driver){

		this.driver = driver;

	}
	private void clickCreateRepo(){

		driver.findElement(createRepoBtn).click();

	}
	//Set repository description in textbox
	private void setDescrptionRepo(String strDesc){

		driver.findElement(descRepoFiled).sendKeys(strDesc);

	}

	//Set repository name in textbox

	private void setNameRepo(String strName){

		driver.findElement(nameRepoFiled).sendKeys(strName);

	}
	public void createRpository(String strName,String strDesc){

		//Fill repository name

		this.setNameRepo(strName);

		//Fill repository description

		this.setDescrptionRepo(strDesc);

		//Click create repository button

		this.clickCreateRepo();        
	}

	public String getNewRepoTitle(){

		return    driver.findElement(repoTitle).getText();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
