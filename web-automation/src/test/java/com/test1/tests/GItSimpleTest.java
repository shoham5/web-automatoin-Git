package com.test1.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.pages.GitLogin;
import com.pages.GitNewRepository;
import com.pages.GitOpenNewIssue;
import com.pages.GitUserHome;
import com.pages.GitWriteIssue;
import com.pages.GitHome;
import com.pages.GitIssueBeforeWrite;
import com.pages.GitIssues;


public class GItSimpleTest {
	WebDriver driver;
	final String _NAME = "";
	final String _PSSSWORD = "";
	final String _WEB = "https://github.com/";
	


	GitLogin objLogin;
	GitHome objHomePage;
	GitUserHome objUserHome;
	GitIssues objIssue;
	GitNewRepository objNewRepo;
	GitWriteIssue objWriteIssue;
	GitOpenNewIssue objOpenNew;
	GitIssueBeforeWrite objBeforeWrite;

	@BeforeTest

	public void setup(){

		System.setProperty("webdriver.gecko.driver", "D:\\gekodriver\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(_WEB);

	}



	/**

	 * This test case will nevigate to https://github.com/

	 * Verify home page using Dashboard message :"built for developers"

	 * @throws InterruptedException 

	 */


	@Test(priority=0)
	public void test_Git_Home_Page_Appear_Correct() throws InterruptedException
	{
		// create Git home page 
		objHomePage = new GitHome(driver);

		//Verify home page
		Thread.sleep(1000);
		Assert.assertTrue(objHomePage.getHomePageTitle().toLowerCase().contains("built for developers"));
		//go to the next page 
		objHomePage.clickSignIn();
	}


	/**

	 * This test case will login in https://github.com/login

	 * Verify name text field as _NAME
	 * Verify  password text field as _PASSWORD

	 * Login to application

	 * @throws InterruptedException 

	 */
	@Test(priority=0)
	public void test_Git_Login_Page_Correct() throws InterruptedException {

		
		//Create Login Page object

		objLogin = new GitLogin(driver);

		//Verify login page title

		String loginPageTitle = objLogin.getLoginTitle();

		Assert.assertTrue(loginPageTitle.toLowerCase().contains("username or email address"));
		objLogin.loginToGit(_NAME,_PSSSWORD);
		Thread.sleep(1000);
	}


	@Test(priority=0)
	public void test_Git_UserHome_Page_Appear_Correct() throws InterruptedException {
	
		//go to user Home page 
		objUserHome = new GitUserHome(driver);

		//Verify user Page title
		String userPageTitle = objUserHome.getUserHomeTitle();

		Assert.assertTrue(userPageTitle.toLowerCase().contains("repositories"));
		
		objUserHome.clickNewRepo();

		Thread.sleep(1000);

		//go to New repository Page
		objNewRepo = new GitNewRepository(driver);
		String newRepoPageTitle = objNewRepo.getNewRepoTitle();
		
		//Verify New repository page title
		Thread.sleep(1000);

		Assert.assertTrue(newRepoPageTitle.toLowerCase().contains("new"));

		Thread.sleep(2000);
		objNewRepo.createRpository("sec", "this is sec repo");

	}

	@Test(priority=0)
	public void test_Git_Isuue_New_Appear_Correct() throws InterruptedException {
		//create issue page
		//driver.get("https://github.com/shohamha/testWeb/");
		objIssue = new GitIssues(driver);
		Thread.sleep(1000);
		objIssue.startIssueTab();
		String newIssueTitle = objIssue.getIssueTitle();
		//Verify New repository page title
		Thread.sleep(1000);
		Assert.assertTrue(newIssueTitle.toLowerCase().contains("welcome"));


	}




	//@Test(priority=0)
	public void test_Git_Create_New_Issue() throws InterruptedException {
		//driver.get("https://github.com/shohamha/testWeb/issues/");
		//create issue page

		objBeforeWrite = new GitIssueBeforeWrite(driver);
		Thread.sleep(1000);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebElement isuueBtn = driver.findElement(By.xpath("(//*[contains(@class,'btn-primary')])[2]"));
		JavascriptExecutor exeTab = (JavascriptExecutor)driver;
		exeTab.executeScript("arguments[0].click();", isuueBtn);
		objBeforeWrite = new GitIssueBeforeWrite(driver);
		Thread.sleep(2000);

		//String newIssueTitle = objBeforeWrite.getIssueTitle();
		//Assert.assertTrue(newIssueTitle.toLowerCase().contains("about"));


	}


	@Test(priority=0)
	public void test_Git_Filed_text_New_Issue() throws InterruptedException 
	{	
		//driver.get("https://github.com/shohamha/testWeb/issues/new/");
		//create issue page

		objWriteIssue = new GitWriteIssue(driver);
		objWriteIssue.createIssue("firstIsuue", "welcome all");

		Thread.sleep(2000);
		WebElement nweBtn = driver.findElement(By.xpath("(//*[contains(@class,'btn-primary')])[2]"));
		JavascriptExecutor exeBtn = (JavascriptExecutor)driver;
		exeBtn.executeScript("arguments[0].click();", nweBtn);
		Thread.sleep(2000);
	}

	@AfterTest
	public void firefoxClose(){
		driver.quit();
	}


}
